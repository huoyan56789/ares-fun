package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Ares
 * @Date 2018/7/17 11:06
 * @Description: 堆排序
 * 堆排序是一种不稳定的排序，最好时间复杂度为O(nlogn),最坏时间复杂度为O(nlogn),平均时间复杂度为O(nlogn)
 * @Version JDK 1.8
 */
public class HeapSort
{
    //14.9秒
    private static final int COUNT = 100000;

    public static void heapSort(int[] numArr)
    {
        System.out.println("开始排序");
        int arrayLength = numArr.length;
        //循环建堆
        for (int i = 0; i < arrayLength - 1; i++)
        {
            //建堆
            buildMaxHeap(numArr, arrayLength - 1 - i);
            //交换堆顶和最后一个元素
            swap(numArr, 0, arrayLength - 1 - i);
            //System.out.println(Arrays.toString(numArr));
        }
    }

    private static void swap(int[] data, int i, int j)
    {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    //对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(int[] data, int lastIndex)
    {
        //从lastIndex处节点的父节点（最后一个非叶子结点）开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--)
        {
            //k保存正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while(k * 2 + 1 <= lastIndex)
            {
                //k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex)
                {
                    //如果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1])
                    {
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex])
                {
                    //交换他们
                    swap(data, k, biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                }
                else
                {
                    break;
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
        heapSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
