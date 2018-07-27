package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Ares
 * @Date 2018/7/18 11:19
 * @Description: 快速排序
 * 快速排序是不稳定的排序算法，最好的时间复杂度是O（nlogn）,最坏的时间复杂度O(n^2),平均时间复杂度是O(nlogn)
 * 占用内存较大，但速度极快
 * @Version JDK 1.8
 */
public class QuickSort
{
    //时间太短，大致在厘秒级
    //private static final int COUNT = 100000;
    //14.2秒
    private static final int COUNT = 100000000;

    public static void quickSort(int[] numArr)
    {
        quickSort(numArr, 0, numArr.length - 1);
    }

    private static void quickSort(int[] numArr, int start, int end)
    {
        //这部分代码有问题，不符合快速思想，但最终结果是正确的
/*        if (start < end) {
            int base = numArr[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numArr[i] < base) && (i < end))
                    i++;
                while ((numArr[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numArr[i];
                    numArr[i] = numArr[j];
                    numArr[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numArr, start, j);
            if (end > i)
                quickSort(numArr, i, end);
        }*/


        //下列代码是交换式，将基准数不断交换
/*        int left = start;
        int right = end;
        int base = numArr[start];

        while(left < right)
        {
            while(left < right && numArr[right] >= base)
                right--;

            //这里做了一个判断，如果不做判断会执行left==right时的交换，也就是自己和自己交换
            //这个判断并不是很有必要，因为执行判断的成本和其内部代码执行的成本相差不多,具体视数量级和实际数据集而定
//            if (left < right)
//            {
//                int temp = numArr[left];
//                numArr[left] = numArr[right];
//                numArr[right] = temp;
//            }
            int temp = numArr[left];
            numArr[left] = numArr[right];
            numArr[right] = temp;

            while(left < right && numArr[left] <= base)
                left++;

            //这里做了一个判断，如果不做判断会执行left==right时的交换，也就是自己和自己交换
            //这个判断并不是很有必要，因为执行判断的成本和其内部代码执行的成本相差不多,具体视数量级和实际数据集而定
//            if (left < right)
//            {
//                int temp = numArr[left];
//                numArr[left] = numArr[right];
//                numArr[right] = temp;
//            }
            temp = numArr[left];
            numArr[left] = numArr[right];
            numArr[right] = temp;
        }
        //递归
       //这里要进行判断，禁止left==start时的执行递归函数
        if (left > start)
            quickSort(numArr, start, left - 1);//左边序列。第一个索引位置到关键值索引-1
        //这里要进行判断，禁止left==start时的执行递归函数
        if (right < end)
            quickSort(numArr, right + 1, end);//右边序列。从关键值索引+1到最后一个*/



        //以下代码为填坑式，相比交换式应该更省变量和交换的过程
     /*   if (start < end)
        {
            int left = start, right = end, base = numArr[start];
            while(left < right)
            {
                while(left < right && numArr[right] >= base) // 从右向左找第一个小于x的数
                    right--;

                //这里做了一个判断，如果不做判断会执行left==right时的交换，也就是自己和自己交换
                //这个判断并不是很有必要，因为执行判断的成本和其内部代码执行的成本相差不多,具体视数量级和实际数据集而定
                //if (left < right)
                numArr[left++] = numArr[right];

                while(left < right && numArr[left] <= base) // 从左向右找第一个大于等于x的数
                    left++;
                //这里做了一个判断，如果不做判断会执行left==right时的交换，也就是自己和自己交换
                //这个判断并不是很有必要，因为执行判断的成本和其内部代码执行的成本相差不多,具体视数量级和实际数据集而定
                // (left < right)
                numArr[right--] = numArr[left];
            }
            numArr[left] = base;

            quickSort(numArr, start, left - 1); // 递归调用
            quickSort(numArr, left + 1, end);
        }*/

        if (start < end)
        {
            int left = start, right = end, base = numArr[start];
            while(left < right)
            {
                while(left < right && numArr[right] >= base) // 从右向左找第一个小于base的数
                    right--;
                numArr[left++] = numArr[right];

                while(left < right && numArr[left] <= base) // 从左向右找第一个大于base的数
                    left++;
                numArr[right--] = numArr[left];
            }
            numArr[left] = base;

            quickSort(numArr, start, left - 1); // 递归调用
            quickSort(numArr, left + 1, end);
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
        quickSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
