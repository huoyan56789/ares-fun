package datastructure.set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Ares
 * @date 2018/7/5 14:56
 */
public class TreeSetDemo
{
    public static void main(String[] args)
    {
        TreeSet set = new TreeSet();
        //可用于collection的互相转换
//        TreeSet treeSet = new TreeSet(new ArrayList());
        //指定比较器
//        TreeSet compareSet = new TreeSet(new Comparator()
//        {
//            @Override
//            public int compare(Object o1, Object o2)
//            {
//                return 0;
//            }
//        });

        set.add("ares");
        set.add("love");
        set.add("ai");
        System.out.println(set);
        System.out.println(set.size());

        //set.headSet返回从首元素到该元素（不包括它）之间的元素的set集合
        System.out.println(set.headSet("love"));
        //set.tailSet返回从尾元素到该元素（不包括它）之间的元素的set集合
        System.out.println(set.tailSet("ares"));

        set.add("lqw");
        set.add("xixi");
        System.out.println(set);
        //lower获取该元素的前一个元素
        System.out.println(set.lower("xixi"));
        System.out.println(set);
    }
}
