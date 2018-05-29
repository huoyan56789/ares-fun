package algorithm.condense;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Ares
 * @date 2018/5/21 12:32
 */
public class HexToChar
{
    public static void main(String[] args)
    {
        String s = "5478";
//        byte[] bytes = mergeToBytes(s);
//        System.out.println(Arrays.toString(bytes));
        char[] chars = mergeToChars(s);
        for (int i = 0; i < chars.length; i++)
        {
            System.out.println(chars[i]);
            System.out.println((int)chars[i]);
        }
    }
    /**
     * 将16进制字符串转换为byte[]
     *
     * @param str
     * @return
     */
    public static byte[] mergeToBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bytes = new byte[str.length() >> 1];
        for(int i = 0; i < str.length() >> 1; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    /**
     * 将16进制字符串转换为char[]
     *
     * @param str
     * @return
     */
    public static char[] mergeToChars(String str) {
        if(str == null || str.trim().equals("")) {
            return new char[0];
        }
        char[] chars = new char[str.length() >> 1];
        for(int i = 0; i < str.length() >> 1; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            chars[i] = (char) Integer.parseInt(subStr, 16);
        }

        return chars;
    }
}

