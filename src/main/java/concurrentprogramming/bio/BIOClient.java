package concurrentprogramming.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 阻塞式I/O创建的客户端
 *
 * @author Ares
 * @date 2018/7/9 10:34
 */

public class BIOClient
{
    //默认的端口号
    private static int DEFAULT_SERVER_PORT = 9999;
    private static String DEFAULT_SERVER_IP = "127.0.0.1";

    public static void send(String expression)
    {
        send(DEFAULT_SERVER_PORT, expression);
    }

    public static void send(int port, String expression)
    {
        System.out.println("算术表达式为：" + expression);
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try
        {
            socket = new Socket(DEFAULT_SERVER_IP, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            //发送消息，println是放置消息内容
            out.println(expression);
            System.out.println("计算结果为：" + in.readLine());
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            //一下必要的清理工作
            if (in != null)
            {
                try
                {
                    in.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                in = null;
            }
            if (out != null)
            {
                out.close();
                out = null;
            }
            if (socket != null)
            {
                try
                {
                    socket.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}