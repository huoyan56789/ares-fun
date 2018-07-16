package concurrentprogramming.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author Ares
 * @date 2018/6/14 15:06
 */


public class PipeConnection
{

    public static void main(String[] args)
    {
        /**
         * 创建管道输出流
         */
        PipedOutputStream pos = new PipedOutputStream();
        /**
         * 创建管道输入流
         */
        PipedInputStream pis = new PipedInputStream();
        try
        {
            /**
             * 将管道输入流与输出流连接 此过程也可通过重载的构造函数来实现
             */
            pos.connect(pis);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        /**
         * 创建生产者线程
         */
        Producer producer = new Producer(pos);
        /**
         * 创建消费者线程
         */
        Consumer consumer = new Consumer(pis);
        /**
         * 启动线程
         */
        producer.start();
        consumer.start();
    }
}

/**
 * 生产者线程(与一个管道输入流相关联)
 */
class Producer extends Thread
{
    private PipedOutputStream pos;

    public Producer(PipedOutputStream pos)
    {
        this.pos = pos;
    }

    public void run()
    {
        int i = 0;
        try
        {
            while(true)
            {
                this.sleep(3000);
                pos.write(i);
                i++;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者线程(与一个管道输入流相关联)
 */
class Consumer extends Thread
{
    private PipedInputStream pis;

    public Consumer(PipedInputStream pis)
    {
        this.pis = pis;
    }

    public void run()
    {
        try
        {
            //这里要一直读,不然线程结束输入流就关闭了
            while(true)
            {
                System.out.println("consumer: " + pis.read());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}