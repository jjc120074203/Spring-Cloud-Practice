为什么要使用线程池？
对于大部分服务器应用程序的来说话，C端接受请求的时候呢，都会每一个请求创建一个新的线程，并且在新线程长执行服务。正常情况下是没有问题
如果在程序部署的情况下 如果也采用这样的方式的话，就会带来明显的不足。为每个请求部署创建一个新的线程，在线程创建已经销毁的上花费的时间
以及系统资源往往比处理用户请求的时间消耗的的多得多。除 此之外过得多的线程，可能还会导致 资源用完的问题。
线程池的优势:
1.线程池主要为了线程的生命周期开销问题和资源不足的问题提供一种解决方案比如说一个任务 ：创建线程+销毁线程 的时间远远大于任务执行的时间
2.能极大的提高任务的重用率,可以减少处理单元的闲置时间，增加处理单元的吞吐能力。

常见线程池:
Executors 
1.newSingleThreadExecutor 单个 
2.newCacheThreadExecutor(它可以回收空间)
3.newFixedThreadExecutor 固定线程池
4.newScheduleThreadExecutor 支持定时和周期性的执行线程
5.TreadPoolExecutor 


http://blog.csdn.net/lipc_/article/details/52025993
http://www.cnblogs.com/trust-freedom/p/6681948.html
  
new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
corePoolSize:核心线程数量  -- A
maximumPoolSize:最大线程数量  --B
workQueue:工作队列，---C SynchronousQueue、LinkedBlockingQueue和ArrayBlockingQueue
threadFactory:创建线程工厂  --D

执行任务中会出现的几种情况:
1.当运行中的线程数量 num <A 的时候，线程池会创建一个新的线程运行当前任务。
2.当 A <=num<B的时候,多余num-A的线程会进入C，根据队列规则进行排队等候。
3.当 A <=num<B时并且 num-A 无法进入 队列C的时候，此时线程池会临时安排一个非核心线程进行当前任务。
4.当num>=B 时候，进入阻绝策略
5.关于线程回收  
	当 A <=num<B的时候，num-A中某个线程处理完成的任务了，但是在keepAlive范围内仍然没有任务分配的话，线程就会被回收




---------------------------------------------------------------------
死锁：
1.两个线程A、B 。一直持有对方要等待的资源。无线等待

死锁的预防：
1.控制好锁的顺序。
2.增加一个限定时间，如果超出这个时间还没完成，就释放锁。
3.死锁检测机制。当一个线程获得了锁的话，用一个标识位将其记下

活锁：线程队列中拿出一个任务来执行，如果失败了，继续加入队列中，继续尝试。 可能会自行解开




