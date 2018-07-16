package concurrentprogramming.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 一个方法中如果只有另一个用synchronized修饰的方法，那么相当于该方法上也用synchronized的效果
 *
 * @author Ares
 * @date 2018/7/3 14:09
 */
public class SynchronizedUse
{

    private static int num = 0;

    /**
     * 1.用synchronized保证操作的原子性
     */
    //    private synchronized static void increase()
    //    {
    //        num++;
    //    }
    //
    //    public static void increaseNum()
    //    {
    //        increase();
    //    }
    //这种写法和上述方法效果一致
    private static void increase()
    {
        num++;
    }

    public synchronized static void increaseNum()
    {
        increase();
    }

    //使用CountDownLatch来等待计算线程执行完
    static int threadCount = 10;
    static CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    public static void main(String[] args)
    {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++)
        {
            new Thread(() -> {
                for (int k = 0; k < 1000; k++)
                {
                    increaseNum();
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
    }


}
