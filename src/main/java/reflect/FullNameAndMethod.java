package reflect;

import java.util.List;

/**
 * @Author Ares
 * @Date 2018/7/30 22:51
 * @Description: 1、在类的实例中可使用this.getClass().getName();但在static method中不能使用该方法；
 * 2、在static method中使用方法:Thread.currentThread().getStackTrace()[1].getClassName();
 * 3.获取方法名：Thread.currentThread().getStackTrace()[1].getMethodName();
 * 4. 获取代码行号：Thread.currentThread().getStackTrace()[1].getLineNumber();
 * @Version JDK 1.8
 */
public class FullNameAndMethod
{
    private String getFullName()
    {
        return this.getClass().getName();
    }

    public static  void main(String[] args)
    {
        //第一种
        FullNameAndMethod fullNameAndMethod = new FullNameAndMethod();
        String fullName = fullNameAndMethod.getFullName();
        System.out.println("全名为: " + fullName);

        //第二种
        //Thread.currentThread().getStackTrace()[1]是你当前方法执行堆栈
        //Thread.currentThread().getStackTrace()[2]就是上一级的方法堆栈 以此类推
        System.out.println("全名为: " + Thread.currentThread().getStackTrace()[1].getClassName());

        System.out.println("全名为: " + FullNameAndMethod.class.getName());
        System.out.println("全名为: " + FullNameAndMethod.class.getCanonicalName());

        //获取方法名
        System.out.println("当前方法名为: " + Thread.currentThread().getStackTrace()[1].getMethodName());

        //获取行号
        System.out.println("当前行号为: " + Thread.currentThread().getStackTrace()[1].getLineNumber());
    }
}
