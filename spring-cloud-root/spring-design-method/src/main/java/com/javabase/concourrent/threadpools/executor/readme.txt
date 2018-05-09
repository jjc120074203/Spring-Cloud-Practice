Executors:主要提供一些方便创建ThreadPoolExecutor的方法

常用
newFixedThreadPool [固定线程池-keepAliveTime 0 | 缓冲队列 LinkedBlockingQueue]

newSingleThreadExecutor [创建单个线程池 任务为1的  缓冲队列 LinkedBlockingQueue]

newCachedThreadPool [可变线程池  keepAliveTime 1 分钟]


newScheduledThreadPool [延时线程 ]
 