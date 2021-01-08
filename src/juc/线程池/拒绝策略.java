package juc.线程池;

/**
 * @Author: anzhi
 * @Date: 2020/12/30 18:00
 */
public class 拒绝策略 {


    /**
     * 1.AbortPolicy 丢弃任务，并抛出RejectedExecutionException异常
     * 2.DiscardOldestPolicy 丢弃最早被放入到线程队列里的任务，将新提交的任务放入到线程队列末端
     * 3.DiscardPolicy 直接丢弃新的任务，不抛异常
     * 4.CallerRunsPolicy 由调用线程处理该任务
     */





}
