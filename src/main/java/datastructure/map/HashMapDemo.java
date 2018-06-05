package datastructure.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Ares
 * @date 2018/6/4 15:55
 */
public class HashMapDemo
{
    public static void main(String[] args)
    {
        Map map = new HashMap();
        map.put(1,"love");
        map.put(3,"ares");
        map.put(4,"xue");
        map.put(2,"bing");
        map.put(5,null);
        map.put(null,1);
        map.put(null,null);
        map.forEach((k,v) -> System.out.println("key:" + k + ",value:" + v));


        //指定初始化时的容量，和扩容的加载因子，以及迭代输出节点的顺序,accessOrder默认为false，
        // 则迭代时输出的顺序是插入节点的顺序。若为true，则输出的顺序是按照访问节点的顺序
        map = new LinkedHashMap<String, String>(10, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.get("2");//2移动到了内部的链表末尾
        map.get("4");//4调整至末尾
        map.put("3", "e");//3调整至末尾
        map.put(null, null);//插入两个新的节点 null
        map.put("5", null);//5
        System.out.println("----------------LinkedHashMap-----------------");
        map.forEach((k,v) -> System.out.println("key:" + k + ",value:" + v));
    }
}
