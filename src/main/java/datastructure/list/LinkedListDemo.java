package datastructure.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList基于链表实现没有所谓的容量概念和扩容一说
 * 继承了Deque即双向队列，其元素可以随意进出，不必像单向队列那样先进先出(FIFO)
 * 因为继承了Deue和list接口所以同一个操作有很多中api，效果极其接近
 *
 * @author Ares
 * @date 2018/7/5 13:54
 */
public class LinkedListDemo
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        //构造函数经常用于list的转换
        //        LinkedList linkedList = new LinkedList(new ArrayList());
        list.add("ares");
        list.add("love");
        list.add("ai");
        list.add("you");

        //        System.out.println("getFirst: " + list.getFirst());
        //        System.out.println("getLast: " + list.getLast());
        //        //removeFirst返回被移除的元素
        //        System.out.println("removeFirst: " + list.removeFirst());
        //        System.out.println(list);
        //        //removeLast返回被移除的元素
        //        System.out.println("removeLast: " + list.removeLast());
        //        System.out.println(list);
        //        list.addFirst("ares");
        //        System.out.println(list);
        //        //addLast和add效果一致，只不过add会返回一个boolean值
        //        list.addLast("you");
        //        System.out.println(list);
        //        System.out.println(list.contains("ai"));
        //        System.out.println(list.contains("a"));

        //remove(value)移除元素时如果元素不存在返回false,如果存在移除后返回true
        //remove(index)移除元素后返回旧值，超过下标则报异常
        //remove()调用了removeFirst()默认删除首个元素
        //        System.out.println(list.remove());
        //         System.out.println(list.remove("hai"));
        //        System.out.println(list.remove(0));

        //addAll（list）调用了addAll（index,list），后一个的意思是在指定下标处开始插入list中的元素
        //        List addList = new ArrayList<>();
        //        addList.add("xixi");
        //        addList.add(null);
        //        //list.addAll(addList);
        //        list.addAll(1, addList);
        //        System.out.println(list);

        //        System.out.println(list.get(0));
        //        //set在指定位置修改元素并返回旧值
        //        System.out.println(list.set(2, "what"));

        //indexOf和lastIndexOf如果元素不存在返回-1，indexOf是从前向后匹配返回第一个匹配的下标，lastIndexOf是从后向前匹配
        //        list.addFirst("ares");
        //        list.add("ares");
        //        System.out.println(list);
        //        System.out.println(list.indexOf("ares"));
        //        System.out.println(list.lastIndexOf("ares"));

        //element调用了getFirst方法，返回第一个元素
        //        list.remove(list.lastIndexOf("ares"));
        //        System.out.println(list);
        //        System.out.println(list.element());

        //poll移除并返回首个元素
        //        System.out.println(list);
        //        System.out.println(list.poll());
        //        System.out.println(list);

        System.out.println(list);
        //offer(value)调用了add方法，添加一个元素在末尾并返回true，完全等价于add
        System.out.println(list.offer("hello"));
        System.out.println(list);

        //peek返回首个元素但不做任何操作，效果和getFirst()类似
        System.out.println(list.peek());
        System.out.println(list);

        //toArray转会换成数组时如果需要多余的空间可以显式地声明一个数组（指定大小）
        String[] strs = (String[]) list.toArray(new String[10]);
        System.out.println(Arrays.toString(strs));

        //removeLastOccurrence的移除是从后向前匹配，元素不存在则不操作返回false，存在则移除返回true
        //可以等价于list.remove(list.lastIndexOf("ares"));的效果
        list.add("ares");
        System.out.println(list);
        System.out.println(list.removeLastOccurrence("ares"));
        System.out.println(list.removeLastOccurrence("a"));
        System.out.println(list);
    }
}
