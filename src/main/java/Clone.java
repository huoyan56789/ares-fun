import entity.Person;
import entity.Thing;

/**
 * @author Ares
 * 通过clone实现对象的创建，对象需实现Cloneable的clone方法
 * @date 2018/6/26 10:41
 */
public class Clone
{
    public static void main(String[] args)
    {
        Thing thing = new Thing();
        thing.setNum(100);
        thing.setDifficulty("重大");
        thing.setPerson(new Person("ares", "男", 22));
        try
        {
            Thing thingClone = (Thing)thing.clone();
            System.out.println("被复制的对象:" + thing);
            System.out.println("复制得到的对象" + thingClone);

            thingClone.setNum(120);
            thingClone.setDifficulty("中等");
            System.out.println("修改基本类型变量和字符串类型后");
            System.out.println("被复制的对象:" + thing);
            System.out.println("复制得到的对象" + thingClone);

            /*
            浅复制时，因为操作的还是同一个对象所以改了一个另一个也会变化；
            深复制时，因为相当于重新赋值，所以是不同的对象。
             */
            thingClone.getPerson().setName("我被改啦");
            System.out.println("修改引用变量类型后");
            System.out.println("被复制的对象:" + thing);
            System.out.println("复制得到的对象" + thingClone);
        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}
