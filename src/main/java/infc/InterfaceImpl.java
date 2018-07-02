package infc;

/**
 * @author Ares
 * @date 2018/5/30 10:12
 */
public class InterfaceImpl extends FunctionRepeat implements InterfaceSon
{
    //接口中defalt方法实现类可以选择性的实现(不实现和实现都可以),实现的话就是重写
    @Override
    public void run()
    {

    }

    //FunctionRepeat和InterfaceSon都有love方法，不实现和实现都可以
    //不实现这里使用的就是父类的方法，实现的话相当于覆盖
    @Override
    public void love()
    {

    }

    @Override
    public void sayLove()
    {

    }

    public static void main(String[] args)
    {
       new InterfaceImpl().love();
    }
}
