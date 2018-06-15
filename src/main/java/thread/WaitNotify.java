package thread;

/**
 * @author Ares
 * @date 2018/6/14 10:37
 */


public class WaitNotify
{
    /*
    1）wait()、notify()和notifyAll()方法是本地方法，并且为final方法，无法被重写。
    2）调用某个对象的wait()方法能让当前线程阻塞，并且当前线程必须拥有此对象的monitor（即锁，或者叫管程）
    3）调用某个对象的notify()方法能够唤醒一个正在等待这个对象的monitor的线程，如果有多个线程都在等待这个对象的
    monitor，则只能唤醒其中一个线程(随机,不依赖优先级，但厂商可能有不同的实现，比如优先级高的);
    4）调用notifyAll()方法能够唤醒所有正在等待这个对象的monitor的线程(随机,不依赖优先级，但厂商可能有不同的实现，比如优先级低的先唤醒)；
     */

    // 在多线程间共享的对象上使用wait
    private String[] shareObj = {"true"};

    public static void main(String[] args)
    {
        WaitNotify waitNotify = new WaitNotify();
        ThreadWait threadWaitOne = waitNotify.new ThreadWait("wait thread1");
        threadWaitOne.setPriority(2);
        ThreadWait threadWaitTwo = waitNotify.new ThreadWait("wait thread2");
        threadWaitTwo.setPriority(3);
        ThreadWait threadWaitThree = waitNotify.new ThreadWait("wait thread3");
        //优先级高的线程先启动
        threadWaitThree.setPriority(4);

        ThreadNotify threadNotify = waitNotify.new ThreadNotify("notify thread");

        threadNotify.start();
        threadWaitOne.start();
        threadWaitTwo.start();
        threadWaitThree.start();
    }

    class ThreadWait extends Thread
    {

        public ThreadWait(String name)
        {
            super(name);
        }

        public void run()
        {
            synchronized (shareObj)
            {
                while("true".equals(shareObj[0]))
                {
                    System.out.println("线程" + this.getName() + "开始等待");
                    long startTime = System.currentTimeMillis();
                    try
                    {
                        shareObj.wait();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    long endTime = System.currentTimeMillis();
                    System.out.println("线程" + this.getName() + "等待时间为：" + (endTime - startTime));
                }
            }
            System.out.println("线程" + getName() + "等待结束");
        }
    }

    class ThreadNotify extends Thread
    {

        public ThreadNotify(String name)
        {
            super(name);
        }


        public void run()
        {
            try
            {
                // 给等待线程等待时间
                sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            synchronized (shareObj)
            {
                System.out.println("线程" + this.getName() + "开始准备通知");
                shareObj[0] = "false";
//                shareObj.notify();
//                shareObj.notify();
                shareObj.notifyAll();
                System.out.println("线程" + this.getName() + "通知结束");
            }
            System.out.println("线程" + this.getName() + "运行结束");
        }
    }
}