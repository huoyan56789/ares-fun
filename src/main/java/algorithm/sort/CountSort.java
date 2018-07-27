package algorithm.sort;

import utils.NumberUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Ares
 * @Date 2018/7/23 16:48
 * @Description: 计数排序
 * 空间复杂度：这个我们已经看到了，用了一个辅助数组C，一个辅助数组B,复杂度为o(n+k);
 * 时间复杂度：我们看到遍历了两次n，一次k，大小也是o(n+k)
 * 当k很小的时候，明显可以看到此算法复杂度比较快，适用于k较小，内存空间较大的情况
 * 稳定
 * @Version JDK 1.8
 */
public class CountSort
{
    //22.0秒
    private static final int COUNT = 100000000;

    public static int[] countSort(int[] numArr, int maxNum)
    {
        int[] countArr = new int[maxNum + 1];
        for (int i = 0; i < numArr.length; i++)
        {
            countArr[numArr[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < maxNum + 1; i++)
        {
            sum += countArr[i];
            countArr[i] = sum;
        }
        //经过上面的处理得到下标值所对应元素的位置（如果有相同元素是最后一后的位置）
        int[] tempArr = new int[numArr.length];
        for (int i = numArr.length - 1; i >= 0; i--)//遍历A数组，构造B数组
        {
            //位置和下标差1，且向前递推
            countArr[numArr[i]]--;
            tempArr[countArr[numArr[i]]] = numArr[i];//将A中该元素放到排序后数组B中指定的位置
        }
        return tempArr;
    }

    public static int[] countSort(int[] numArr)
    {
        int maxNum = NumberUtils.getMax(numArr);
        return countSort(numArr, maxNum);
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int[] numArr = new int[COUNT];
        for (int i = 0; i < COUNT; i++)
        {
            numArr[i] = random.nextInt(COUNT);
        }
        //numArr = new int[]{5, 8, 9, 1, 4, 2, 9, 3, 7, 1, 8, 6, 2, 3, 4, 0, 8};
        long startTime = System.currentTimeMillis();
        numArr = countSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
        System.out.println(Arrays.toString(numArr));
    }
}
