package concurrentprogramming.aio;

/**
 * @author Ares
 * @date 2018/7/16 11:13
 */

public class Server
{
    private static int DEFAULT_PORT = 9999;
    private static AsyncServerHandler serverHandle;
    public volatile static long clientCount = 0;

    public static void start()
    {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port)
    {
        if (serverHandle != null)
            return;
        serverHandle = new AsyncServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args)
    {
        Server.start();
    }
}