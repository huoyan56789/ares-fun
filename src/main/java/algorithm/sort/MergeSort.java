package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Ares
 * @Date 2018/7/18 16:49
 * @Description: 归并排序
 * 速度仅次于快排，内存少的时候使用，可以进行并行计算的时候使用
 * 最好，最坏，平均时间复杂度都是O(nlogn)
 * 稳定算法
 * @Version JDK 1.8
 */
public class MergeSort
{
    //19.6秒
    private static final int COUNT = 100000000;

    // TODO: 2018/7/18 当前代码还可以优化
    public static void mergeSort(int[] numArr)
    {
        //传入一个数组，防止递归时频繁开辟空间（创建新数组）
        mergeSort(numArr, 0, numArr.length - 1, new int[numArr.length]);
    }

    private static void mergeSort(int[] numArr, int start, int end, int[] tempArr)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;
            //左边归并排序，使得左子序列有序
            mergeSort(numArr, start, mid, tempArr);
            //右边归并排序，使得右子序列有序
            mergeSort(numArr, mid + 1, end, tempArr);
            //将两个有序子数组合并操作
            merge(numArr, start, mid, end, tempArr);
        }
    }

    private static void merge(int[] numArr, int start, int mid, int end, int[] tempArr)
    {
        //左序列指针
        int left = start;
        //右序列指针
        int right = mid + 1;
        //临时数组指针
        int temp = 0;

        while(left <= mid && right <= end)
        {
            if (numArr[left] <= numArr[right])
            {
                tempArr[temp++] = numArr[left++];
            }
            else
            {
                tempArr[temp++] = numArr[right++];
            }
        }

        while(left <= mid)
        {
            //将左边剩余元素填充进temp中
            tempArr[temp++] = numArr[left++];
        }

        while(right <= end)
        {
            //将右边剩余元素填充进temp中
            tempArr[temp++] = numArr[right++];
        }

        temp = 0;
        while(start <= end)
        {
            numArr[start++] = tempArr[temp++];
        }
        //和上面等价，只不过是从后向前赋值
        // temp = temp -1 ;
        // while(start <= end)
        // {
        //      numArr[end--] = tempArr[temp--];
        // }
    }


    public static void main(String[] args)
    {
        Random random = new Random();
        int[] numArr = new int[COUNT];
        for (int i = 0; i < COUNT; i++)
        {
            numArr[i] = random.nextInt(COUNT);
        }
        //numArr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        long startTime = System.currentTimeMillis();
        mergeSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
