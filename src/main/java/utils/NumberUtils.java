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

    /*
   *   产生随机范围随机大小的整数数组
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
}
