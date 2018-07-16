package datastructure.list;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Ares
 * @date 2018/7/5 11:26
 */
public class ForAndForeach
{
    static int param = 0;

    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList();
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < 100000; i++)
        {
            arrayList.add(i);
            linkedList.add(i);
        }

        int array = 0;
        long startTime = System.currentTimeMillis();
        for (Integer i : arrayList)
        {
            array = i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("新型for循环遍历ArrayList用时: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < arrayList.size(); i++)
        {
            array = arrayList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("下标for循环遍历ArrayList用时: " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        arrayList.forEach(i -> {
            param = i;
        });
        endTime = System.currentTimeMillis();
        System.out.println("foreach遍历ArrayList用时: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (Integer i : linkedList)
        {
            array = i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("新型for循环遍历linkedList用时: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++)
        {
            array = linkedList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("下标for循环遍历linkedList用时: " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        linkedList.forEach(i -> {
            param = i;
        });
        endTime = System.currentTimeMillis();
        System.out.println("foreach遍历linkedList用时: " + (endTime - startTime));
    }
}
