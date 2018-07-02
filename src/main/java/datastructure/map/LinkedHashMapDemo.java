package datastructure.map;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ares
 * @date 2018/6/29 15:38
 */
public class LinkedHashMapDemo
{
    public static void main(String[] args)
    {

        //LinkedHashMap的默认初始大小，加载因子和扩容方式都是继承HashMap的
        //指定初始化时的容量，和扩容的加载因子，以及迭代输出节点的顺序,accessOrder默认为false，则迭代时输出的顺序是插入节点的顺序。
        //若为true，则输出的顺序是按照访问节点(每次访问会把该节点移动到末尾)的顺序

        Map map = new LinkedHashMap<String, String>(0, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.get("2");//2移动到了内部的数组末尾
        map.get("4");//4调整至末尾
        map.put("3", "e");//3调整至末尾
        map.put(null, null);//插入两个新的节点 null
        map.put("5", null);//5
        System.out.println("----------------LinkedHashMap-----------------");
        map.forEach((k, v) -> System.out.println("key:" + k + ",value:" + v));
    }
}
