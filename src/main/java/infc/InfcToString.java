package infc;

/**
 * @author Ares
 * @date 2018/5/30 9:36
 */
public class InfcToString
{
    public static void main(String[] args)
    {
        InterfaceDemo infc = null;
        //直接声明一个「接口」类型的变量时，此变量将拥有 Object 的所有方法,但下面会报空指针异常
        System.out.println(infc.toString());

//        //下面的写法错误，因为只声明了引用，没有实例化对象
//        InterfaceDemo infterface;
//        System.out.println(infterface.toString());

        //下面的写法错误，因为1是字面量(字面量（literal）是用于表达源代码中一个固定值的表示法（natation）)，没有toString()这个静态方法
//        System.out.println(1.toString());
    }
}
