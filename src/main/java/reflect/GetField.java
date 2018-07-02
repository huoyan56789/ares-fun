package reflect;

import entity.Student;

import java.lang.reflect.Field;

/**
 * @author Ares
 * @date 2018/6/22 11:34
 */
public class GetField
{
    /**
     * 使用反射获取成员变量(私有变量)
     * @param args
     */
    public static void main(String[] args)
    {
        /*
        这里以age为例，获取age的值和修改age的值
         */
        Student student = new Student();
        student.setAge(22);
        try
        {
            Field ageField = student.getClass().getDeclaredField("age");
            //成员变量name是私有的，所以得先取消语言访问检查  public void setAccessible(boolean flag)
            ageField.setAccessible(true);
            //获取对象的属性的值
            String age = ageField.get(student).toString();
            System.out.println("age为" + age);
            //修改对象的属性的值
            ageField.set(student, 23);
            System.out.println("修改后的age为" + ageField.get(student).toString());
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
