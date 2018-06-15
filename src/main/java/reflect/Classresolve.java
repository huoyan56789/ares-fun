package reflect;

import entity.Love;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author Ares
 * @date 2018/4/25 11:22
 */
public class Classresolve
{
    public static void main(String[] args)
    {
        Love love = new Love();
        Class clazzLove = love.getClass();
        System.out.println("通过类的实例获取的class: " + clazzLove);
        Constructor [] constructorsLove = clazzLove.getConstructors();
        Arrays.stream(constructorsLove).forEach(i -> System.out.println("我是构造方法: " + i));
        //getFields()获得某个类的所有的公共（public）的字段，包括父类。
        //getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
        Field [] fieldsLove = clazzLove.getDeclaredFields();
        Arrays.stream(fieldsLove).forEach(i -> System.out.println("我是字段: " + i));


        Class clazz = Love.class;
        System.out.println("通过类名直接获取的class: " + clazz);
        Constructor [] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(i -> System.out.println("我是构造方法: " + i));
        Field [] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(i -> System.out.println("我是字段: " + i));

        Class classForName = null;
        try
        {
            classForName = Class.forName("entity.Love");
            Constructor [] constructorsForName = clazz.getConstructors();
            System.out.println("通过Class的静态方法获取的class: " + classForName);
            Arrays.stream(constructorsForName).forEach(i -> System.out.println("我是构造方法: " + i));
            Field [] fieldsForName = classForName.getDeclaredFields();
            Arrays.stream(fieldsForName).forEach(i -> System.out.println("我是字段: " + i));
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
