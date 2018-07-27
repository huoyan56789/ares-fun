package algorithm.sort;

import java.util.Random;

/**
 * @Author Ares
 * @Date 2018/7/17 10:39
 * @Description: 选择排序
 * 选择排序是不稳定的排序，平均时间复杂度为O(n^2)，最好时间复杂度为O(n),最坏时间复杂度为O(n^2)
 * @Version JDK 1.8
 */
public class SelectSort
{
    //6.7秒
    private static final int COUNT = 100000;

    public static void selectSort(int[] numArr)
    {
        int length = numArr.length;
        for (int i = 0; i < length; i++)
        {//循环次数
            int key = numArr[i];
            int position = i;
            for (int j = i + 1; j < length; j++)
            {//选出最小的值和位置
                if (numArr[j] < key)
                {
                    key = numArr[j];
                    position = j;
                }
            }
            numArr[position] = numArr[i];//交换位置
            numArr[i] = key;
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
        selectSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
