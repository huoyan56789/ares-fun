package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Ares
 * @Date 2018/7/18 10:30
 * @Description: 冒泡排序
 * 冒泡排序是一种稳定的排序，最好时间复杂度为O(n^2),最坏时间复杂度为O(n),平均时间复杂度为O(n^2)
 * @Version JDK 1.8
 */
public class BubbleSort
{
    //20.1秒
    private static final int COUNT = 100000;

    public static void bubbleSort(int[] numArr)
    {
        int temp;
        for (int i = 0; i < numArr.length; i++)
        {
          /*  for (int j = i + 1; j < numArr.length; j++)
            {
                if (numArr[i] > numArr[j])
                {
                    temp = numArr[i];
                    numArr[i] = numArr[j];
                    numArr[j] = temp;
                }
            }*/
            //和上面等价
            for (int j = 0; j < numArr.length - i - 1; j++)
            {
                if (numArr[j] > numArr[j + 1])
                {
                    temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;
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
        bubbleSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
