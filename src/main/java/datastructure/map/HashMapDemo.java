package datastructure.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ares
 * HashMap由数组+链表组成的，数组（元素是Node<K,V>，属性有hash值，key，value和一个指针，指向同一hash值的Node<K,V>）是HashMap的主体，
 * 链表则是主要为了解决哈希冲突而存在的，如果定位到的数组位置不含链表（当前entry的next指向null）,那么对于查找，添加等操作很快，仅需一次寻址即可；
 * 如果定位到的数组包含链表，对于添加操作，其时间复杂度为O(n)，首先遍历链表，存在即覆盖，否则新增；
 * 对于查找操作来讲，仍需遍历链表，然后通过key对象的equals方法逐一比对查找。所以，性能考虑，HashMap中的链表出现越少，性能才会越好。
 * 为了优化上面说的链表的性能问题使用了红黑树算法，当哈希冲突发生较少时，HashMap桶中的元素结构依旧是链表，
 * 当超过树化阈值（默认TREEIFY_THRESHOLD=8）时，会进行树化，将整个HashMap桶从链表转为红黑树
 * 如果在创建时给定了初始化大小，那么HashTable会直接使用你给定的大小，而HashMap会将其扩充为2的幂次方大小
 * HashMap如果数目较大，最好指定初始大小，不然扩容太多会影响效率
 * 新创建的HashMap本身的hashcode都是0,如果其中的元素不发生改变，则调用该方法返回的哈希码值相同，否则返回的哈希码值将发生改变
 * 不同的Map元素如果一样那么hashCode也一样
 * HashMap线程不安全，Collections.synchronizedMap(new HashMap)这样写就可以保证线程安全
 * @date 2018/6/28 13:44
 */
public class HashMapDemo
{
    public static void main(String[] args)
    {
        //不带参数的情况下初始大小为16（在内存中开辟的大小足以容纳16个键值对），加载因子为0.75，扩容方式为 x=当前容量*2（扩容方式只有这一种）,取>=x的第一个2的整数次幂
        //加载因子越高，空间利用率越高，但是查询时间和添加时间增加，用时间换空间，加载因子对应着负载因子即散表的装满程度
        Map map = new HashMap();

        //带一个参数指定了初始大小,加载因子为0.75，扩容方式为当前容量*2,采用这种方式可以减少扩容的性能损耗，阿里建议使用实际大小*4/3 + 1。
        //Hashmap的容量总会是是2的幂次，比如下方虽然为10但初始容量其实是16，有利于位运算而位运算的效率很高
        //初始大小可以为0，这样做会频繁扩容但节省空间，适用于小容量
        //        Map initialCapacity = new HashMap(10);

        //带一个参数指定了初始大小和加载因子，扩容方式为当前容量*2，当扩容因子大于0.25小于4.0时，当前容量除以加载因子然后加1(如果比默认值16小，直接扩容到16)
        //如果比2的29次方大，只扩容到2的29次方),所以理论上来说，HashMap的最容量为2的29次方
        //        Map initialCapacityAndLoadFactor = new HashMap(2, 3.0f);
        //        initialCapacityAndLoadFactor.put(1,2);
        //        initialCapacityAndLoadFactor.put(2,1);
        //        System.out.println(initialCapacityAndLoadFactor.hashCode());

        //可以直接用Map做参数，可以实现转换或是复制的作用
        //        Map hashMap = new HashMap(map);

        //map.size()返回当前map的大小
        //        System.out.println("map的大小为: " + map.size());
        //        map.put("love", "dear");
        //        map.put("hello", "ares");
        //        System.out.println("map的大小为: " + map.size());

        //map.isEmpty()返回当前map是否为空'
        //        System.out.println("map是否为空: " + map.isEmpty());
        //        map.put("love", "dear");
        //        System.out.println("map是否为空: " + map.isEmpty());


        //map.remove()移除元素，没有该key则不移除且并不报错
        //        map.remove("love");
        //        System.out.println(map);
        //        map.put("love", "dear");
        //        map.remove("hai");
        //        System.out.println(map);

        //map.containsKey()是否包含key
        //        map.put("love", "dear");
        //        System.out.println(map.containsKey("ares"));
        //        System.out.println(map.containsKey("love"));


        //map.putAll()把一个Map的键值对全部放入另一个map
        //        Map hashMap = new HashMap();
        //        hashMap.put("love", "ares");
        //        hashMap.put("hai", "hello");
        //        map.putAll(hashMap);
        //        System.out.println(map);

        //map.clear()清空map
        //        map.put("love", "dear");
        //        map.put("hai", "hello");
        //        map.clear();
        //        System.out.println(map);

        //map.containsValue是否存在该值
        //        map.put("love", "dear");
        //        map.put("hai", "hello");
        //        System.out.println(map.containsValue("hello"));
        //        System.out.println(map.containsValue("ares"));

        // map.keySet()获取key的Set集合,map.values()获取值的集合,map.entrySet()获取键值对的Set集合（元素是Map.Entry）
        //        map.put("love", "dear");
        //        map.put("hai", "hello");
        //        System.out.println(map.keySet());
        //        System.out.println(map.values());
        //        System.out.println(map.entrySet());


        //map.getOrDefault根据key获取值，如果键存在则返回对应的值，如果不存在则返回默认值
        //        map.put("love", "dear");
        //        map.put("hai", "hello");
        //        System.out.println(map.getOrDefault("love", "爱情"));
        //        System.out.println(map.getOrDefault("ares", "爱情"));


        //map.putIfAbsent()重复则不插入也不更新
        //        map.putIfAbsent("love", "dear");
        //        map.putIfAbsent("love", "hello");
        //        map.putIfAbsent("love", "ai");
        //        System.out.println(map);

        //map.replace(K,V,V)如果键和值都匹配则修改其值(键和值一个不匹配就不替换)
        //map.replace(K, V)如果键不匹配则不操作
        //和map.put的区别在于键不存在一个是插入一个是不插入
        //        map.put("love", "dear");
        //        map.put("hai", "hello");
        //        map.replace("ares", "xixi", "ai");
        //        map.replace("love", "xixi", "ai");
        //        System.out.println(map);
        //        map.replace("love", "dear", "ai");
        //        System.out.println(map);
        //        map.replace("ha", "xixi");
        //        System.out.println(map);
        //        map.replace("hai", "xixi");
        //        System.out.println(map);

        //如果想使用HashMap的clone方法，必须声明为HashMap而不是Map，因为Map中没有Clone方法，HashMap中的clone继承自Object
        //实现Map的复制可以直接使用HashMap的初始化将原map传入即可
        //        map.clone();
        //        HashMap hashMap = new HashMap();
        //        hashMap.put("hai", "love");
        //        Map mapClone = (HashMap) hashMap.clone();
        //        System.out.println(mapClone);
        //        mapClone.put("ares", "xixi");
        //        System.out.println(mapClone);
        //        System.out.println(hashMap);

        //map.merge将key比较，如果key不存在则插入，返回值为value(不管表达式为何)
        //如果key存在，将旧value和新value做操作插入并返回
        //        map.put("love", "dear");
        //        map.put("ares", "xixi");
        //        System.out.println(map);
        //        String s = (String) map.merge("hai", "ai", (oldV, newV) -> oldV);
        //        System.out.println(map);
        //        System.out.println(s);
        //        String str = (String) map.merge("hai", "woqu", (oldV, newV) -> newV);
        //        System.out.println(map);
        //        System.out.println(str);


        //forEach时不能对map进行修改,但可以对其中的元素进行修改,如果想对alue进行遍历改变操作使用
        // 下面的replaceAll和compute,也可以可以copy一个map进行修改
        //        map.put("love", "dear");
        //        map.put("ares", "xixi");
        //        map.forEach((k, v) -> System.out.println(k + ":" + v));

        //map.replaceAll()对Map中的每个映射执行function指定的操作，并用function的执行结果替换原来的value,
        // 它不能对key进行改变，源码中并未有对k的修改
        //        map.put("love", "dear");
        //        map.put("ares", "xixi");
        //        System.out.println(map);
        //        map.replaceAll((k, v) -> v.toString().toUpperCase());
        //        System.out.println(map);

        //compute也是对value的修改（单个，指定key的），但这里可以指定key，如果key在map不存在，将表达式的值(不为null时)作为value和key一起插入
        //如果key在map中已存在用执行结果替换原来的value
        //computeIfAbsent只有key不存在或者为null时才进行操作
        map.put("love", "dear");
        map.put("ares", "xixi");
        //HashMap在实现时对null做了特殊处理，将null的hashCode值定为了0，从而将其存放在哈希表的第0个bucket中
        map.put(null, "xixi");
        map.compute(null, (k, v) -> v);
        System.out.println(map);
        map.compute("hai", (k, v) -> null);
        System.out.println(map);
        map.compute("hai", (k, v) -> k.toString().toUpperCase());
        System.out.println(map);
        System.out.println(map.put("hahaha", "miss"));
        System.out.println(map.put("hahaha", "miss you"));
//        map.compute("love", (k,v) -> v.toString().toUpperCase());
//        System.out.println(map);
//        map.computeIfAbsent("di", k -> k.toString().toUpperCase());
//        System.out.println(map);

        //key和value都可以为null
//        map = new HashMap();
//        map.put(1,"love");
//        map.put(3,"ares");
//        map.put(4,"xue");
//        map.put(2,"bing");
//        map.put(5,null);
//        map.put(null,1);
//        map.put(null,null);
//        map.forEach((k,v) -> System.out.println("key:" + k + ",value:" + v));


    }

}
