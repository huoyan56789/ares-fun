package infc;

/**
 * @author Ares
 * @date 2018/5/30 9:55
 */
public interface InterfaceDemo
{
    //错误
//    abstract static void run();

    //错误
//    default abstract void run();

    //正确，所以接口里的方法不能有方法体这一说法在jdk8里不成立，应该是抽象方法不能有方法体
    default void run(){};

    //正确,但是必须有方法体,所以接口里的方法不能有方法体这一说法在jdk8里不成立，应该是抽象方法不能有方法体
    static void func(){};

    //正确，原始的接口的写法，其中abstract可以省略, 所以等价于void love();
    public abstract void love();
}
