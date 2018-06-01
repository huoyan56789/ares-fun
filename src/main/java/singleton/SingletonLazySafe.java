package singleton;

/**
 * @author Ares
 * @date 2018/5/30 11:26
 */
public class SingletonLazySafe
{
    private SingletonLazySafe()
    {
    }

    private static SingletonLazySafe single = null;

    /*
     * 1、在getInstance方法上加同步实现线程安全
     */
    //    public static synchronized SingletonLazySafe getInstance() {
//        if (single == null) {
//            single = new SingletonLazySafe();
//        }
//        return single;
//    }


    /*
     * 2.双重检查锁定实现线程安全
     * 此时要加上volatile关键字，假设没有关键字volatile的情况下，两个线程A、B，都是第一次调用该单例方法，
     * 线程A先执行instance = new Instance()，该构造方法是一个非原子操作，
     * 编译后生成多条字节码指令，由于JAVA的指令重排序，可能会先执行instance的赋值操作，
     * 该操作实际只是在内存中开辟一片存储对象的区域后直接返回内存的引用，之后instance便不为空了，
     * 但是实际的初始化操作却还没有执行，如果就在此时线程B进入，就会看到一个不为空的但是不完整（没有完成初始化）的Instance对象，
     * 所以需要加入volatile关键字，禁止指令重排序优化，从而安全的实现单例
     */
    //    private static volatile SingletonLazySafe single = null;
//    public static SingletonLazySafe getInstance() {
//        if (single == null) {
//            synchronized (SingletonLazySafe.class) {
//                if (single == null) {
//                    single = new SingletonLazySafe();
//                }
//            }
//        }
//        return single;
//    }

    /*
     *3.静态内部类,这种方式最好,既实现了线程安全，又避免了同步带来的性能影响
     */
    private static class LazyHolder {
        private static final SingletonLazySafe INSTANCE = new SingletonLazySafe();
    }

    public static final SingletonLazySafe getInstance() {
        return LazyHolder.INSTANCE;
    }
}
