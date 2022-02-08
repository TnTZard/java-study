## CopyOnWrite容器

### 什么是CopyOnWrite容器

CopyOnWrite是计算机设计领域中的一种优化策略，也是一种在并发场景下常用的设计思想。

> 写入时复制思想

当有多个调用者同时去请求一个资源数据的时候，有一个调用者出于某些原因需要对当前的数据源进行修改，这个时候系统将会复制一个当前数据源的副本给调用者修改。

CopyOnWrite容器即**写时复制容器**，当往一个容器中添加元素的时候，不直接往容器中添加，而是将当前容器进行copy，复制出来一个新的容器，然后向新容器中添加我们需要的元素，最后将原容器的引用指向新容器。

这样做的好处在于，我们可以在并发的场景下对容器进行“读操作”而不需要“加锁”，从而达到读写分离的目的。

### CopyOnWriteArrayList

**优点**： CopyOnWriteArrayList经常被用于“读多写少”的并发场景，是因为CopyOnWriteArrayList无需任何同步措施，大大增强了读的性能。在Java中遍历线程非安全的List(如：ArrayList和 LinkedList)的时候，若中途有别的线程对List容器进行修改，那么会抛出ConcurrentModificationException异常。CopyOnWriteArrayList由于其"读写分离"，遍历和修改操作分别作用在不同的List容器，所以在使用迭代器遍历的时候，则不会抛出异常。

**缺点**： 第一个缺点是CopyOnWriteArrayList每次执行写操作都会将原容器进行拷贝了一份，数据量大的时候，内存会存在较大的压力，可能会引起频繁Full GC（ZGC因为没有使用Full GC）。比如这些对象占用的内存比较大200M左右，那么再写入100M数据进去，内存就会多占用300M。

```java
public boolean add(E e) {
    // ReentrantLock加锁，保证线程安全
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        Object[] elements = getArray();
        int len = elements.length;
        // 拷贝原容器，长度为原容器长度加一
        Object[] newElements = Arrays.copyOf(elements, len + 1);
        // 在新副本上执行添加操作
        newElements[len] = e;
        // 将原容器引用指向新副本
        setArray(newElements);
        return true;
    } finally {
        // 解锁
        lock.unlock();
    }
}
```

再来看remove操作的源码，remove的逻辑是将要remove元素之外的其他元素拷贝到新的副本中，然后切换引用，再将原容器的引用指向新的副本中，因为remove操作也是“写操作”所以也是要加锁的。

```java
public E remove(int index) {
    // 加锁
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        Object[] elements = getArray();
        int len = elements.length;
        E oladValue = get(elements, index);
        int numMoved = len - index - 1;
        if (numMoved == 0) {
            // 如果要删除的是列表末端数据，拷贝前len-1个数据到新副本上，再切换引用
            setArray(Arrays.copyOf(elements, len - 1));
        } else {
            // 否则，将除了要删除元素之外的其他元素拷贝到新副本中，并切换引用
            Object[] newElements = new Object[len - 1];
            System.arraycopy(elements, 0, newElements, 0, index);
            System.arraycopy(elements, index + 1, newElements, index, numMoved);
            setArray(newElements);
        }
        return oldValue;
    } finally {
        // 解锁
        lock.unlock();
    }
}
```

读操作的源码

```java
public E get(int index) {
    return get(getArray(), index);
}
```

```java
private E get(Object[] a, int index) {
    return (E) a[index];
}
```

由上可见，读操作没有加锁，直接读取。

### CopyOnWrite的业务中实现

具体结合业务场景实现一个CopyOnWriteMap的并发容器来使用它

```java
public class CopyOnWriteMap<K, V> implements Map<K, V>, Cloneable {
    private volatile Map<K, V> internalMap;
    public CopyOnWriteMap() {
        internalMap = new HashMap<K, V>();
    }
    
   	public V put(K key, V value) {
        synchronized(this) {
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            V val = newMap.put(key, value);
            internalMap = newMap;
            return val;
        }
    }
    
    public V get(Object key) {
        return internalMap.get(key);
    }
    
    public void putAll(Map<? extends K, ? extends V> newData) {
        synchronized (this) {
            Map<K, V> newMap = new HashMap<K, V>(internalMap);
            newMap.putAll(newData);
            internalMap = newMap;
        }
    }
    
}
```

**场景：**假如我们有个一搜索的网站需要屏蔽一些“关键字”，“黑名单”每晚定时更新，每当用户搜索的时候，”黑名单“中的关键字不会出现在搜索结果当中，并且提示用户敏感字。

```java
public class BlackListServiceImpl {
    private static CopyOnWriteMap<String, Boolean> blackListMap = new CopyOnWriteMap<String, Boolean>(1000);
    
   	public static boolean isBlackList(String id) {
        return blackListMap.get(id) == null ? false ：true;
    }
    
    public static void addBlackList(String id) {
        blackListMap.put(id, Boolean.TRUE);
    }
    
    public static void addBlackList(Map<String,Boolean> ids) {
        blackListMap.putAll(ids);
    }
    
}
```

这里需要特别特别注意一个问题，此处的场景是每晚凌晨“黑名单”定时更新，原因是CopyOnWrite容器有**数据一致性**的问题，它只能保证**最终数据一致性**。

所以如果我们希望写入的数据马上能准确地读取，请不要使用CopyOnWrite容器

































