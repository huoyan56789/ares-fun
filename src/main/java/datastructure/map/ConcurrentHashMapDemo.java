package datastructure.map;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 相比于Hashtable以及Collections.synchronizedMap()，ConcurrentHashMap在线程安全的基础上提供了更好的写并发能力，但同时降低了对读一致性的要求。
 * ConcurrentHashMap的设计与实现非常精巧，大量的利用了volatile，final，CAS等lock-free技术来减少锁竞争对于性能的影响
 *
 * @author Ares
 * @date 2018/7/2 13:36
 */
public class ConcurrentHashMapDemo
{
    public static void main(String[] args)
    {
        //默认初始容量为16，扩容因子为0.75f，树化阈值为8，红黑树转链表阈值为6，
        //并行度（同时进行一个操作且不产生锁竞争的最大线程数）为16,扩容方式为 x=当前容量*3/2+1，取>=x的第一个2的整数次幂
//        ConcurrentHashMap map = new ConcurrentHashMap();
                ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        //指定初始容量
        //ConcurrentHashMap initialCapacity = new ConcurrentHashMap(17);
        //指定初始容量和加载因子
        //ConcurrentHashMap initialCapacityAndLoadFactor = new ConcurrentHashMap(17,0.8f);
        //指定初始容量和扩容因子和并发度
        //ConcurrentHashMap getInitialCapacityAndLoadFactorAndconcurrencyLevel = new ConcurrentHashMap(17, 0.8f, 32);
        map.put("ares", "love");
        map.put("xixi", "hahaha");
        map.put("di", "hai");
        map.put("wen", "hi");
        //不能放key或者value的null的数据，直接编译错误
        //System.out.println(null, "keng");
        //System.out.println("keng", null);
        System.out.println(map);
        map.forEach((k, v) -> System.out.println("key=" + k + ",value=" + v));
        //并行度阈值为2(如果map中少于两个元素，它就是顺序的。否则，它是并行的,取决于JVM)，
        // 如果希望操作在一个线程中，使用Long.MAX_VALUE作为阈值即可
        //map.forEach(2, (k, v) -> System.out.println("key=" + k + ",value=" + v));
        //        map.forEach(2, (k, v) -> "key=" + k + ",value=" + v, System.out::println);

        //search会把操作过后的返回值返回，注意null不会被传递给消费者函数,它只有一个返回值对应下面就是返回第一个符合条件的value(也可以是key)
        //System.out.println(map.search(16, (k, v) -> v.toString().length() > 4 ? v : null));
        //search的缩小版，只针对key
        //System.out.println(map.searchKeys(Long.MAX_VALUE, i -> i.toString().length() > 3 ? i : null));
        //search的缩小版，只针对value
        //        System.out.println(map.searchValues(Long.MAX_VALUE, i -> i.toString().length() > 3 ? i : null));
        //返回元素的Entry主干
        //        System.out.println(map.searchEntries(Long.MAX_VALUE, i -> i));

        //根据一定的规则对每个参数进行处理并返回一个最终的参数,reduce和search在指定了key和value的类型之后应该不可使用(类型推测不允许)
        //System.out.println(map.reduce(Long.MAX_VALUE, (k, v) -> k+v, (key, keyOther) -> key + keyOther));
        //方法引用的参数类型要一致，不然没法使用
        //System.out.println(map.reduceKeys(Long.MAX_VALUE,String::length, Integer::max));

        //ConcurrentHashMap边遍历边删除或者增加操作不会产生异常(可以不用迭代方式删除元素)，因为其内部已经做了维护，
        //遍历的时候都能获得最新的值。即便是多个线程一起删除、添加元素也没问题
        //        System.out.println(map);
        //        for (Map.Entry<String,String> entry:map.entrySet())
        //        {
        //           map.remove(entry.getKey());
        //        }
        //        for(String s:map.keySet())
        //        {
        //            map.remove(s);
        //        }
        //        map.forEach((k, v) -> {
        //            map.remove(k);
        //        });
        //        System.out.println(map);
    }

}
