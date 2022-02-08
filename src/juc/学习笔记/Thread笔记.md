## Thread类和Runnable接口

继承Thread类，并重写run方法

实现Runnable接口的run方法

## 继承Thread类

查看Thread的构造方法

```java
// 片段1
public Thread(Runnable target) {
    init(null, target, "Thread-"+nextThreadNum(), 0)
}
// 继续init方法
private void init(ThreadGroup g, Runnable target, String name, long stackSize, AccessControlContext acc, boolean inheritThreadLocals) {
	
}
// 片段3- 使用在init方法里初始化AccessControlContext类型的私有属性
this.inheritedAccessControlContext = acc ≠ null ? acc : AccessController.getContext();

// 片段4- 两个对用于支持ThreadLocal的私有属性
ThreadLocal.ThreadLocalMap threadLocals = null;
THreadLocal.ThreadLocalMap inheritableThreadLocals = null;

```

init方法的参数：

g: 指定这个线程是哪个线程组下

target: 指定要执行的任务

name: 线程的名字，多个线程的名字是可以重复的，如果不指定名字，见片段1

stackSize: 

acc: 用于初始化私有变量inheritedAccessControlContext

inheritThreadLocals: 可继承的ThreadLocal, 见片段4，Thread类里面有两个私有属性来支持ThreadLocal

实际情况下，我们直接调用下面两个方法：

```java
Thread(Runnable target)
Thread(Runnable target, String name)
```

## Thread类的几个常用方法

- currentThread(): 静态方法，返回对当前正在执行线程对象的引用
- start(): 开始执行线程的方法，java虚拟机会调用线程内的run()方法
- yield(): yield有放弃的意思（ps：一直以为是领地来着0.0）,  指当前线程愿意让出对当前处理器的占用。
- sleep(): 静态方法，使当前线程睡眠一段时间
- join(): 使当前线程等待另一个线程执行完毕之后再继续执行，内部调用的是Object类的wait方法实现的

## Thread类与Runnable接口的比较

继承Thread 和 实现 Runnable接口 两种方式，优劣：

- 由于java“单继承，多实现”的特性，Runnable接口使用起来比Thread更灵活
- Runnable接口出现更符合面向对象，将线程单独进行对象的封装
- Runnable接口出现，降低了线程对象和线程任务的耦合
- 如果使用线程时不需要使用Thread类的诸多方法，显然使用Runnable接口更为轻量

所以， 通常优先使用 实现Runnable接口这种方式来自定义线程

## Callable、Future and Future Task

有时候我们希望开启一个线程去执行一个任务，并且这个任务执行完成后有个返回值

JDK提供了Callable接口与Future接口解决这个问题，所谓的“异步”模型





