package algorithm.sort;

import utils.NumberUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Ares
 * @Date 2018/7/24 14:20
 * @Description: 基数排序
 * 分为LSD和MSD，这里是LSD
 * 最好最坏平均时间复杂度都是O(d(r+n))，空间复杂度为O(rd+n)
 * 是一种稳定算法
 * 从个位开始对数组做计数排序，直至排序到最高位，极大地节省了空间利用率
 * @Version JDK 1.8
 */
public class RadixSort
{
    //36.0秒
    private static final int COUNT = 100000000;

    public static int[] radixSort(int[] array) {
        if (array == null) {
            return null;
        }

        int maxLength = String .valueOf(NumberUtils.getMax(array)).length();;

        return sortCore(array, 0, maxLength);
    }

    private static int[] sortCore(int[] array, int digit, int maxLength) {
        if (digit >= maxLength) {
            return array;
        }

        final int radix = 10; // 基数
        int arrayLength = array.length;
        int[] count = new int[radix];
        int[] bucket = new int[arrayLength];

        // 统计将数组中的数字分配到桶中后，各个桶中的数字个数
        for (int i = 0; i < arrayLength; i++) {
            count[getDigit(array[i], digit)]++;
        }

        // 将各个桶中的数字个数，转化成各个桶中最后一个数字的下标索引
        for (int i = 1; i < radix; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // 将原数组中的数字分配给辅助数组 bucket
        for (int i = arrayLength - 1; i >= 0; i--) {
            int number = array[i];
            int d = getDigit(number, digit);
            bucket[count[d] - 1] = number;
            count[d]--;
        }

        return sortCore(bucket, digit + 1, maxLength);
    }


    /*
     * 获取 x 这个数的 d 位数上的数字
     * 比如获取 123 的 0 位数,结果返回 3
     *
     * @param x
     * @param d
     * @return
     */
    private static int getDigit(int x, int d) {
        int a[] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
        return ((x / a[d]) % 10);
    }

    public static void main(String[] args)
    {
        Random random = new Random();
        int[] numArr = new int[COUNT];
        for (int i = 0; i < COUNT; i++)
        {
            numArr[i] = random.nextInt(COUNT);
        }
        numArr = new int[]{5352, 835, 92, 15, 435, 2211, 449, 341, 7574, 1474, 899, 635, 2552, 3122, 4144, 14440, 8211};
        long startTime = System.currentTimeMillis();
        numArr = radixSort(numArr);
        long endTime = System.currentTimeMillis();
        System.out.println("排序花费时间为" + (endTime - startTime) + "毫秒");
    }
}
