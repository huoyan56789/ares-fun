package singleton;

/**
 * @author Ares
 * @date 2018/5/30 11:21
 */

/**
 * 懒汉式单例类.在第一次调用的时候实例化自己
 * Singleton通过将构造方法限定为private避免了类在外部被实例化，在同一个虚拟机范围内，
 * Singleton的唯一实例只能通过getInstance()方法访问
 * 以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton实例
 */
public class SingletonLazyNoSafe
{
    private SingletonLazyNoSafe()
    {
    }

    private static SingletonLazyNoSafe single = null;

    //静态工厂方法
    public static SingletonLazyNoSafe getInstance()
    {
        if (single == null)
        {
            single = new SingletonLazyNoSafe();
        }
        return single;
    }

}
