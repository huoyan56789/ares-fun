package utils.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationSimple
{

    public static List<String> permutationSimple(String[] strs)
    {
        int start = 0, end = strs.length - 1;
        List<String> list = perm(strs, start, end, new ArrayList<>());
        return list;
    }

    public static List<String> perm(String[] strs, int start, int end, List<String> list)
    {
        if (start == end)
        {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            String string = "";
            for (int i = 0; i <= end; i++)
            {
                string = string + strs[i] + " ";
            }
            list.add(string);
        }
        else
        {// 多个字母全排列
            for (int i = start; i <= end; i++)
            {
                String temp = strs[start];// 交换数组第一个元素与后续的元素
                strs[start] = strs[i];
                strs[i] = temp;

                perm(strs, start + 1, end, list);// 后续元素递归全排列

                temp = strs[start];// 将交换后的数组还原
                strs[start] = strs[i];
                strs[i] = temp;
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        //permutationSimple对当前数据元素做全排列
        List list = permutationSimple(new String[]{"A", "B", "C"});
        System.out.println("全排列为: " + list);
        System.out.println("全排列个数为: " + list.size());
    }
}
