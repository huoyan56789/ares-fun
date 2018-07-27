package utils;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Ares
 * @date 2018/6/22 13:35
 */
public class NumberUtils
{
    /*
   *   产生指定大小的随机的整数数组
   */
    public static int[] getIntArr(int size, int range)
    {
        int[] values = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
        {
            values[i] = random.nextInt(range);
        }
        return values;
    }

    /*
   *   产生指定大小的随机的整数数组(不指定范围)
   */
    public static int[] getIntArr(int size)
    {
        int[] values = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
        {
            values[i] = random.nextInt();
        }
        return values;
    }

    /**
     * 产生随机范围随机大小的整数数组
     */
    public static int[] getIntArrRandSize(int size, int range)
    {

        Random random = new Random();
        int[] values = new int[random.nextInt(size)];
        for (int i = 0; i < values.length; i++)
        {
            values[i] = random.nextInt(range);
        }
        return values;
    }

    /**
     * 获取数组中的最大值
     */
    public static int getMax(int[] numArr)
    {
        int max = numArr[0];
        for (int i = 1; i < numArr.length; i++)
        {
            if (numArr[i] > max)
            {
                max = numArr[i];
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        int count = 100000000;
        Random random = new Random();
        int[] numArr = new int[count];
        for (int i = 0; i < count; i++)
        {
            numArr[i] = random.nextInt(count);
        }
        long startTime = System.currentTimeMillis();
        int maxNum = getMax(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("当前方法执行共花费" + (endTime - startTime) + "毫秒");
    }
}
