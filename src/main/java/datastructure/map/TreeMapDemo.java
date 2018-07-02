package datastructure.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * TreeMap 是一个有序的key-value集合，它是通过红黑树实现的。
 * TreeMap 继承于AbstractMap，所以它是一个Map，即一个key-value集合。
 * TreeMap 实现了NavigableMap接口，意味着它支持一系列的导航方法。比如返回有序的key集合。
 * TreeMap 实现了Cloneable接口，意味着它能被克隆。
 * TreeMap 实现了java.io.Serializable接口，意味着它支持序列化。
 *
 * @author Ares
 * @date 2018/6/29 15:07
 */
public class TreeMapDemo
{
    public static void main(String[] args)
    {
        //为了实验TreeMap的方法，声明为TreeMap，实际中用Map还是具体类型看需要

        //默认初始化
        //        TreeMap treeMap = new TreeMap();
        //        treeMap.put("xue", "haha");
        //        treeMap.put("di", "xixi");
        //        treeMap.put("love", "ares");


        //        HashMap hashMap = new HashMap();
        //        hashMap.put("xue", "haha");
        //        hashMap.put("di", "xixi");
        //        hashMap.put("love", "ares");
        //        //以一个map复制一个新TreeMap,参数只要是实现了Map接口即可，这里的效果和上面一致
        //        TreeMap treeMap = new TreeMap(hashMap);

        //带比较器的初始化，会按照比较规则排序，按照key值排序规则可自定,值得注意的一点是比较器规定的相等情况下会进行更新
        TreeMap treeMap = new TreeMap<String, String>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.length() - o2.length();
            }
        });
        treeMap.put("xue", "haha");
        treeMap.put("di", "xixi");
        treeMap.put("love", "ares");
        treeMap.put("hahaha", "ai");
        treeMap.put("woqu", "aiyou");

        //键不允许为空,值可以
//        treeMap.put(null, "kong");
        treeMap.put("kong", null);

        System.out.println(treeMap);

        //这些方法当treeMap为空时会抛异常
        System.out.println("map.firstKey():" + treeMap.firstKey());
        System.out.println("map.firstEntry():" + treeMap.firstEntry());
        System.out.println("map.lastKey():" + treeMap.lastKey());
        System.out.println("map.lastEntry():" + treeMap.lastEntry());
        System.out.println("map.pollFirstEntry():" + treeMap.pollFirstEntry());
        System.out.println("map.pollLastEntry():" + treeMap.pollLastEntry());
        System.out.println("map.keySet():" + treeMap.keySet());
        System.out.println("map.descendingKeySet():" + treeMap.descendingKeySet());


        System.out.println("-----------------------------------");
        treeMap.put("di", "xixi");
        treeMap.put("love", "ares");
        treeMap.put("hahaha", "ai");
        treeMap.put("woqu", "aiyou");
        System.out.println(treeMap);
        System.out.println("map.lowerEntry(key):" + treeMap.lowerEntry("hahaha"));
        System.out.println("map.lowerEntry(key):" + treeMap.lowerEntry("xue"));
        System.out.println("map.lowerEntry(key):" + treeMap.lowerEntry("di"));
        System.out.println("map.higherEntry(key):" + treeMap.higherEntry("hahaha"));
        System.out.println("map.higherEntry(key):" + treeMap.higherEntry("xue"));
        System.out.println("map.higherEntry(key):" + treeMap.higherEntry("di"));


        System.out.println("-----------------------------------");
        //这几个函数都有带boolean值的版本用来控制是否包括端点
        System.out.println(treeMap);
        System.out.println("map.descendingMap():" + treeMap.descendingMap());
        System.out.println("map.subMap(key, key):" + treeMap.subMap("di", "hahaha"));
        System.out.println("map.subMap(key, key):" + treeMap.subMap("di", "hahahah"));
        System.out.println("map.subMap(key, key):" + treeMap.subMap("xue", "hahahah"));
        System.out.println("map.headMap(key):" + treeMap.headMap("hahaha"));
        System.out.println("map.headMap(key):" + treeMap.headMap("hahahah"));
        System.out.println("map.headMap(key):" + treeMap.headMap("di"));
        System.out.println("map.tailMap(key):" + treeMap.tailMap("di"));
        System.out.println("map.tailMap(key):" + treeMap.tailMap("xue"));
        System.out.println("map.tailMap(key):" + treeMap.tailMap("hahaha"));

    }
}
