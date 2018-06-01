package lambda;

/**
 * @author Ares
 * @date 2018/5/31 15:09
 */

import json.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Lambda中的方法引用
 */
public class Quote
{
    /**
     * 构造器引用
     * @param student
     * @return
     */
    private Student ConstruntorRef(Supplier<Student> student){
        Student s = student.get();
        return s;
    }

    public void testConstruntorRef()
    {
        Student quote = ConstruntorRef(Student::new);
    }

    /**
     * 静态方法引用
     * @param s
     */
    private static void StaticRef(String s){
        System.out.println(s);
    }

    public void testStaticRef(){
        Arrays.asList("A", "B", "C").forEach(Quote::StaticRef);
        //下面的写法错误
//        Arrays.asList("A", "B", "C").forEach(new Quote()::StaticRef);
    }

    /**
     * 成员方法引用
     * @param s
     */
    private void MemberMethodRef(String s){
        System.out.println(s);
    }

    public void testMemberMethodRef(){
        //下面的写法错误
//        Arrays.asList("A", "B", "C").forEach(Quote::MemberMethodRef);
        Arrays.asList("A", "B", "C").forEach(new Quote()::MemberMethodRef);
    }

    public static void main(String[] args)
    {
        //map的lambda遍历
        Map map = new HashMap();
        map.put("name", "ares");
        map.put("future", "happy");
//        map.forEach((k,v) -> {
//            System.out.println("key为" + k + ",值为" + v);
//        });

        //List<Map>的lambda遍历,需要显式声明
        List<Map> list = new LinkedList<Map>();
        list.add(map);
        map = new HashMap();
        map.put("love", "self");
        list.add(map);
        list.stream().forEach(i -> {i.forEach((k,v) -> {
            System.out.println("key为" + k + ",值为" + v);
        });});

    }
}
