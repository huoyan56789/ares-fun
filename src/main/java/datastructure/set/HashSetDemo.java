package datastructure.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * HashSet使用HashMap实现，所以加载因子初始容量和HashMap相同，包括扩容方式和大小总是2的幂次方
 *
 * @author Ares
 * @date 2018/7/5 14:41
 */
public class HashSetDemo
{
    public static void main(String[] args)
    {
        //默认初始容量为16,加载因子为0.75f，扩容为当前容量*2
        HashSet set = new HashSet();
        //指定初始容量
        //        HashSet initialCapacity = new HashSet(12);
        //指定初始容量和加载因子
        //        HashSet initialCapacityAndLoadFactor = new HashSet(18,0.8f);
        //和list进行转换，会丢弃重复数据
        //        List list = new ArrayList();
        //        list.add("ares");
        //        list.add("love");
        //        list.add("ai");
        //        list.add("ares");
        //        HashSet newSet = new HashSet(list);
        //        System.out.println(newSet);

        set.add("ares");
        set.add("love");
        set.add("ai");
        set.add("ares");
        System.out.println(set);
        System.out.println(set.size());
        //存在则移除返回true，不存在返回fasle
        System.out.println(set.remove("ae"));
        System.out.println(set.remove("ai"));
        System.out.println(set);

        //是否为空，清空
        System.out.println("是否为空: " + set.isEmpty());
        set.clear();
        System.out.println(set);
        System.out.println("是否为空: " + set.isEmpty());

        System.out.println("是否存在: " + set.contains("a"));
    }
}
