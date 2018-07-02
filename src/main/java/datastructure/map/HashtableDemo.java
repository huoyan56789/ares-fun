package datastructure.map;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;


/**
 * 线程安全
 * 默认初始容量为11，扩容因子为0.75，扩容方式为当前容量*2+1
 * key和value都不能为null,编译虽然没错但运行会报空指针
 * 如果在创建时给定了初始化大小，那么HashTable会直接使用你给定的大小，而HashMap会将其扩充为2的幂次方大小，
 * 当哈希表的大小为素数时，简单的取模哈希的结果会更加均匀，但在取模计算时，如果模数是2的幂，
 * 那么我们可以直接使用位运算来得到结果，效率要大大高于做除法，所以Hashtable的HashMap的初始化和hash策略各有优点，
 * 总体上HashMap更好些,hash的不均匀可以通过其他方法去解决，可以理解为HashMap是Hashtable的进化版
 * HashTable已经被淘汰了，不要在代码中再使用它
 * @author Ares
 * @date 2018/7/2 10:16
 */
public class HashtableDemo
{
    public static void main(String[] args)
    {
        //默认初始容量为11，扩容因子为0.75，扩容方式为当前容量*2+1
        Hashtable table = new Hashtable();
        //指定初始化容量
        // Hashtable initialCapacityTable = new Hashtable(10);
        //指定初始化容量和加扩容因子
        //Hashtable initialCapacityAndLoadFactor = new Hashtable(10,0.8f);
        table.put("ares", "love");
        table.put("di", "hai");
        table.put("xixi", "hahaha");
        table.put("life", "future");
        table.put("life", "future");
        //key和value都不能为null,编译虽然没错但运行会报空指针
        //        table.put("ares",  null);
        //        table.put(null, "love");
        System.out.println(table);

        //keys()返回key的枚举值集合，可以利用其遍历，很少使用
        //        Enumeration en = table.keys();
        //        while(en.hasMoreElements())
        //        {
        //            System.out.println(en.nextElement());
        //        }

        //elements返回value的枚举值集合，很少使用
        //        Enumeration enumeration = table.elements();
        //        while(enumeration.hasMoreElements())
        //        {
        //            System.out.println(enumeration.nextElement());
        //        }

        //containsValue调用contains
        System.out.println(table.contains("hahaha"));
        System.out.println(table.containsValue("hahaha"));
    }
}
