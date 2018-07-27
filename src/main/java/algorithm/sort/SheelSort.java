package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序（增量序列采取n/2）
 * 希尔排序是不稳定的排序，其时间复杂度与增量序列d相关
 * 已知的最好步长序列是由Sedgewick提出的(1, 5, 19, 41, 109,...)，该序列的项来自这两个算式。
 * 一般来说希尔排序的速度在插入排序和快速排序之间。
 * 最坏时间复杂度为O(n^2),最好时间复杂度为O(n),平均时间复杂度为O（n^1.3）
 *
 * @author Ares
 * @date 2018/7/16 17:21
 */
public class SheelSort
{
    //private static final int count = 100000;
    //3.8秒
    private static final int COUNT = 10000000;
    //67.8秒
//    private static final int COUNT = 100000000;

    public static void sheelSort(int[] a)
    {
        int d = a.length;
        while(d != 0)
        {
            d = d / 2;
            for (int x = 0; x < d; x++)
            {//分的组数
                for (int i = x + d; i < a.length; i += d)
                {//组中的元素，从第二个数开始
                    int j = i - d;//j为有序序列最后一位的位数
                    int temp = a[i];//要插入的元素
                    for (; j >= 0 && temp < a[j]; j -= d)
                    {//从后往前遍历。
                        a[j + d] = a[j];//向后移动d位
                    }
                    a[j + d] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int[] numArr = new int[COUNT];
        for (int i = 0; i < COUNT; i++)
        {
            numArr[i] = random.nextInt(COUNT);
        }
        long startTime = System.currentTimeMillis();
        sheelSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
