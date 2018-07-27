package algorithm.sort;

import java.util.Random;

/**
 * 直接插入排序
 * 直接插入排序是一种稳定的排序方法，平均时间复杂度为 O(n^2)
 * 最好时间复杂度为O(n),最坏时间复杂度为O(n^2)
 * @author Ares
 * @date 2018/7/16 16:37
 */
public class InsertSort
{
    //1.2秒
    private static final int COUNT = 100000;

    public static void insertSort(int[] a)
    {
        int length = a.length;//数组长度，将这个提取出来是为了提高速度。
        int insertNum;//要插入的数
        for (int i = 1; i < length; i++)
        {//插入的次数
            insertNum = a[i];//要插入的数
            int j = i - 1;//已经排序好的序列元素个数
            while(j >= 0 && a[j] > insertNum)
            {//序列从后到前循环，将大于insertNum的数向后移动一格
                a[j + 1] = a[j];//元素移动一格
                j--;
            }
            a[j + 1] = insertNum;//将需要插入的数放在要插入的位置。
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
        insertSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
