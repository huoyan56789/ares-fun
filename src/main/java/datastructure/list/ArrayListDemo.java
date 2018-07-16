package datastructure.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

/**
 * @author Ares
 * @date 2018/7/4 11:22
 */
public class ArrayListDemo
{
    public static void main(String[] args)
    {
        //默认容量为10，加载因子为1（不可指定），扩容方式为 x=当前容量*3/2 + 1,取值为x
        ArrayList list = new ArrayList();
        //指定ArrayList的初始容量
        //        ArrayList initialCapacity = new ArrayList(10);
        //以list为原型创建一个新的list，可以用于类型转换
        //        List linkedList = new LinkedList();
        //        linkedList.add("love");
        //        ArrayList arrayList = new ArrayList(linkedList);
        //        System.out.println(arrayList);

        list.add("ares");
        list.add("love");
        list.add("hai");
        list.add("di");
        //list可以放置null，且可以放置多个
        list.add(null);
        list.add(null);


        //此方法不会删除任何值，只是修正列表的大小以节省空间，如默认容量为10，使用此方法后列表的占用空间就变成了4
        //合理的使用可以优化性能
        list.trimToSize();
        list.forEach(System.out::println);

        //ensureCapacity(int n),这个方法可以对ArrayList低层的数组进行扩容，显示的调用这个函数，
        // 如果参数大于低层数组长度的1.5倍，那么这个数组的容量就会被扩容到这个参数值，
        // 如果参数小于低层数组长度的1.5倍，那么这个容量就会被扩容到低层数组长度的1.5倍
        //合理的使用可以优化性能
        list.ensureCapacity(100);

        System.out.println("list是否为空: " + list.isEmpty());
        System.out.println("list的大小: " + list.size());
        //contains本质上还是使用indexOf
        System.out.println("list是否包含: " + list.contains("ares"));


        System.out.println("list的第一个匹配的下标: " + list.indexOf("a"));
        System.out.println("list的第一个匹配的下标: " + list.indexOf("ares"));
        System.out.println("list的第一个匹配的下标: " + list.indexOf("di"));
        System.out.println("list的第一个匹配的下标: " + list.indexOf(null));
        System.out.println("list的最后一个匹配的下标: " + list.lastIndexOf(null));

        //这里用List或者ArrayList都可以，但不能用LinkedList，这涉及到强制转换，
        // 而ArrayList和LinkedList不能相互强转，转换需要通过构造器
        ArrayList arrayListClone = (ArrayList) list.clone();
        System.out.println(arrayListClone);
        List listClone = (List) list.clone();
        System.out.println(listClone);
        //LinkedList linkedListClone = (LinkedList)list.clone();
        //System.out.println(linkedListClone);
        //编译报错，不能强转，两者的底层数据结构都不一样
        // LinkedList linkedListClone = (LinkedList)arrayListClone;
        System.out.println("list转为的数组" + Arrays.toString(list.toArray()));
        //get 根据下标获取元素
        System.out.println(list.get(0));

        //set根据下标修改元素，返回旧元素
        //        System.out.println(list.set(0, "ai"));
        //        System.out.println(list);

        //add可以在指定下标增加元素，其后的元素顺移
        //        list.add(0,"ares");
        //        System.out.println(list);

        //add默认将元素添加在列表最后端并返回true
        //        System.out.println(list.add(""));
        //        System.out.println(list);

        System.out.println(list);
        //如果元素不存在remove返回false，存在则移除返回true
        System.out.println(list.remove("a"));
        list.add("ares");
        //如果存在相同元素，则移除下标在前的元素
        System.out.println(list.remove("ares"));
        System.out.println(list);
        //如果是按照下标移除元素，则返回旧元素
        System.out.println(list.remove(3));
        System.out.println(list);

        ArrayList removeList = new ArrayList();
        removeList.add("love");
        removeList.add("ai");
        //removeAll等价于一个一个移除的效果，在list中有则移除，没有则不操作,有一个元素移除则返回true
        System.out.println(list.removeAll(removeList));
        System.out.println(list);


        //retainAll是取交集，操作过后两个list都成了他们的交集,只要操作完成就发那会true，哪怕交集为一个空集合
        //        ArrayList retainList = new ArrayList();
        //        retainList.add("ai");
        //        System.out.println(list.retainAll(retainList));
        //        System.out.println(list);


        //指定游标的位置，可以只对列表的部分元素做操作
        //ListIterator支持更多的操作（修改，增加，查询当前坐标，逆序遍历），
        // 但如果该集合要保持灵活性和扩展性，最好还是使用Iterator，
        // 这样集合类型修改时(比如从ArrayList转到LinkedList时)不需要进行迭代器部分的代码修改
        //        ListIterator listIterator = list.listIterator(1);
        //        ArrayList listAdd = new ArrayList();
        //        Iterator iterator = list.iterator();
        //        iterator.forEachRemaining(listAdd::add);
        //        System.out.println(listAdd);

        //subList截取元素成一个新的list，元素左闭右开，若两个下标相等则返回空集合
        //        List subList = list.subList(0,1);
        //        System.out.println(subList);

        //并行遍历迭代器用于并法编程提升效率
        //        Spliterator spliterator = list.spliterator();

        //removeif 按照传入的函数表达式判断是否符合条件，符合则移除
        list.removeIf(i -> i == null);
        System.out.println(list);

        //接受一个函数，执行操作后把返回结果作为值代替旧值
        list.replaceAll(i -> i.toString().length() >= 3 ? i : i.toString().toUpperCase());
        System.out.println(list);

        list.sort((value, vlaueOther) -> vlaueOther.toString().length() - value.toString().length());
        System.out.println(list);
    }
}
