package concurrentprogramming.nio;

import java.util.Scanner;

/**
 * @author Ares
 * @date 2018/7/16 11:00
 */

public class NIODemo
{
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
        //运行服务器
        NIOServer.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        NIOClient.start();
        while(NIOClient.sendMsg(new Scanner(System.in).nextLine()))
            ;
    }
}
