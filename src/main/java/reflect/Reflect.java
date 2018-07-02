package reflect;

import entity.Love;
import entity.Loved;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ares
 * @date 2018/4/25 9:47
 */
public class Reflect
{
    public static void main(String[] args)
    {
        try
        {
            /**
             * 无参构造
             */
            //找寻该名称类文件，并加载进内存，并产生Class对象
            Class clazz = Class.forName("entity.Love");
            //直接newInstance,class的newInstance本质上还是调用狗仔的newInstance
            Love love  = (Love) clazz.newInstance();
            System.out.println(love);
            //通过反射调用类中方法
            Method method = clazz.getMethod("setName", String.class);
//            Method method = love.getClass().getMethod("setName", String.class);
            method.invoke(love,"xue");
            System.out.println(love);

            //通过构造器newInstance生成类
            Love loveOther = (Love) clazz.getConstructor().newInstance() ;
            System.out.println(loveOther);

            /**
             * 有参构造
             */
            //通过构造器newInstance
            Class<?> tClass = Class.forName("entity.Loved");
            Constructor constructor = tClass.getConstructor(String.class,Integer.class);
            Loved loved = (Loved) constructor.newInstance("ares",521);
            System.out.println(loved);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}


