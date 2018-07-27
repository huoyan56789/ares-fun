package reflect;

import entity.Loved;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ares
 * @date 2018/7/16 14:28
 */

public class ClassLoaderDemo
{

    public static void main(String[] args) throws ClassNotFoundException
    {

        int i = 0;

        while(true)
        {
            MyClassLoader myClassLoader = new MyClassLoader();
            //双亲委派模式，自定义类加载器的父亲是系统类加载器
            //System.out.println(myClassLoader.getParent());
            Class<?> personClass = myClassLoader.findClass("entity.Person");


            try
            {
                //如果是有参构造器，要获取构造器，然后使用构造器newInstance
                Constructor constructor = personClass.getConstructor(String.class, String.class, int.class);
                Object person = constructor.newInstance("ares", "男", 23);
                Method sayHelloMethod = personClass.getMethod("sayHello");
                sayHelloMethod.invoke(person);
                System.out.println(++i);
            } catch (InstantiationException e)
            {
                e.printStackTrace();
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            } catch (SecurityException e)
            {
                e.printStackTrace();
            } catch (NoSuchMethodException e)
            {
                e.printStackTrace();
            } catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            } catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }

            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

}

