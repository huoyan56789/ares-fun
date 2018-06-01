import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ares
 * @date 2018/5/31 12:31
 */
public class Volatile
{
    //共享变量被多个线程同时操作最后结果不定，大概率小于10000
//    private static int num = 0;
    //volatile不能保证操作原子性
    private static volatile int num = 0;

    /**
     * 3.采用AtomicInteger实现原子性的操作
     */
    public static AtomicInteger inc = new AtomicInteger();

    public static void increaseAtomic() {
        inc.getAndIncrement();
    }

    /**
     * 1.用synchronized保证操作的原子性
     */
    private synchronized static void increase(){
        num++;
    }

    /**
     * 2.用locked保证操作的原子性
     */
    private static Lock lock = new ReentrantLock();
    private static void increaseLock(){
        lock.lock();
        try
        {
            num++;
        }finally
        {
            lock.unlock();;
        }
    }

    //使用CountDownLatch来等待计算线程执行完
    static int threadCount = 10;
    static CountDownLatch countDownLatch = new CountDownLatch(threadCount);
    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++)
        {
            new Thread(()-> {
                for (int k = 0; k < 1000; k++)
                {
                    num++;
//                    increase();
//                     increaseLock();
//                    increaseAtomic();
                }
                countDownLatch.countDown();
            }).start();
        }
        //等待计算线程执行完
        try
        {
            countDownLatch.await();
            long time = System.currentTimeMillis() - startTime;
            System.out.println("执行程序共耗费" + time + "毫秒");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(num);
        System.out.println(inc);
    }
}
