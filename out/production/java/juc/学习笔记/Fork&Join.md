## Fork/Join 框架

Fork/Join 框架是一个实现了ExecutorService接口的多线程处理器，它专为那些可以通过递归分解成更细小地任务而设计，最大化的利用多核处理器来提高应用程序的性能。

与其他ExecutorService相关的实现相同的是，Fork/Join框架会将任务分配给线程池中的线程。而与之不同的是，Fork/Join框架在执行任务时使用了 **工作窃取算法**。

**fork**在英文里有分叉的意思，**join**在英文里连接、结合的意思。顾名思义，fork就是要使一个大任务分解成若干个小人物，而join就是最后将各个小任务的结果结合起来得到大任务的结果。

![fork/join流程图](http://concurrent.redspider.group/article/03/imgs/fork_join%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

图里的次级子任务可以一直分下去，一直分到子任务足够小为止。用伪代码来表示如下：

```java
solve(任务):
    if(任务已经划分到足够小):
        顺序执行任务
    else:
        for(划分任务得到子任务)
            solve(子任务)
        结合所有子任务的结果到上一层循环
        return 最终结合的结果
```

通过上面伪代码可以看出，我们通过递归嵌套的计算得到结果，这里有体现**分而治之（divide and conquer）**的算法思想。

### 工作窃取算法

工作窃取算法指的是在多线程执行不同任务队列的过程中，某个线程执行完自己队列的任务后从其他线程的任务队列里窃取任务来执行。

当一个线程窃取另一个线程的时候，为了减少两个任务线程之间的竞争，我们通常使用**双端队列**来存储任务。被窃取的任务线程都从双端队列的**头部**拿任务执行，而窃取其他任务的线程从双端队列的**尾部**执行任务。

另外，当一个线程在窃取任务时要是没有其他可用的任务了，这个线程就会进入 **阻塞状态** 以等待再次“工作”。

### ForkJoinTask

Fork/Join框架简单来讲就是对任务的分割与子任务的合并，所以要实现这个框架，先得有任务。在Fork/Join框架里提供了抽象类 `FokrJoinTask` 来实现任务。

ForkJoinTask是一个类似普通线程的实体，但是比普通线程轻量得多。

**fork()** : 使用线程池中的空闲线程异步提交任务。

```java
public final ForkJoinTask<V> fork() {
    Thread t;
    // ForkJoinWorkerThread 是执行ForkJoinTask的专有线程，由ForkJoinPool管理
    // 先判断当前线程是否是ForkJoin专有线程，如果是，则将任务push到当前线程所负责的队列里去
    if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
        ((ForkJoinWorkerThread)t).workQueue.push(this);
    } else {
        // 如果不是则将线程加入队列
        // 没有显示创建ForkJoinPool的时候走这里，提交任务到默认的common线程池中 
        ForkJoinPool.common.externalPush(this);
    }
    return this;
}
```

其实fork()只做了一件事，那就是 **把任务推入当前工作线程的工作队列里**。

**join()方法** ：等待处理任务的线程处理完毕，获得返回值

```java
public final V join() {
	int s;
    // doJoin()方法来获取当前任务的执行状态
    if ((s = doJoin() & DONE_MASK) != NORMAL) {
        // 任务异常，抛出异常
        reportException(s);
    }
    // 任务正常完成，获取返回值
    return getRawResult();
}

private int doJoin() {
    int s;
    return (s = status) < 0 ? s :
    ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) ?
        (w = (wt = (ForkJoinWorkerThread)t).workQueue),tryUnpush(this) && (s = doExec()) < 0 ? s : wt.pool.awaitJoin(w, this, 0L) : externalAwaitDone();
}

```

之前说过Thread.Join() 会使线程阻塞，而ForkJoinPool.join() 会使线程免于阻塞，下面是ForkJoinPool.join()的流程图。









































### 