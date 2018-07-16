package concurrentprogramming.nio;

/**
 * @author Ares
 * @date 2018/7/16 10:55
 */
public class NIOServer
{
    private static int DEFAULT_PORT = 9999;
    private static NIOServerHandle serverHandle;

    public static void start()
    {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port)
    {
        if (serverHandle != null)
            serverHandle.stop();
        serverHandle = new NIOServerHandle(port);
        new Thread(serverHandle, "NIOServer").start();
    }

    public static void main(String[] args)
    {
        start();
    }
}

