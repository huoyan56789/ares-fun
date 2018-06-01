package algorithm.encrypt;

import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * @author Ares
 * @date 2018/5/21 9:21
 */
public class Base64Impl
{
    private final static char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '/'};

    public static String baseEncrypt(String s)
    {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
        {
            stringBuffer.append(String.format("%08d", Integer.parseInt(Integer.toBinaryString(s.charAt(i)))));
        }
        int length = stringBuffer.length();
        stringBuffer = length % 24 == 0 ? stringBuffer : (length % 24 == 8 ? stringBuffer.append("0000000000000000") : stringBuffer.append("00000000"));
        StringBuffer tempStr = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i += 6)
        {
            tempStr.append(chars[Integer.parseInt(stringBuffer.substring(i, i + 6), 2)]);
        }
        s = new String(tempStr);
        s = length % 24 == 0 ? s : (length % 24 == 8 ? s.substring(0, s.length() - 2) + "==" : s.substring(0, s.length() - 1) + "=");
        return s;
    }

    public static String baseDecode(String s)
    {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charz = s.toCharArray();
        for (char c : charz)
        {
            if ('=' != c)
            {
                for (int i = 0; i < chars.length; i++)
                {
                    if (c == chars[i])
                    {
                        stringBuffer.append(String.format("%06d", Integer.parseInt(Integer.toBinaryString(i))));
                    }
                }
            }
            else
            {
                stringBuffer.append("000000");
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < stringBuffer.length(); k += 8)
        {
            int i = Integer.parseInt(stringBuffer.substring(k, k + 8), 2);
            if(i != 0){
                char t = (char) i;
                sb.append(t);
            }
        }
        return String.valueOf(sb);
    }

    public static String generateRandom(int length)
    {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++)
        {
            //生成0~61的整数，包括61
            int randNum = new Random().nextInt(62);
            stringBuffer.append(chars[randNum]);
        }
        return String.valueOf(stringBuffer);
    }

    public static void main(String[] args)
    {
        String randomStr = generateRandom(10);
        String str = baseEncrypt(randomStr);
        System.out.println("自己实现的Base64编码后的字符串: " + str);
        String strDecode = baseDecode(str);
        System.out.println("自己实现的Base64解码后的字符串: " + strDecode);

        //jdk内部util，编码
        String string = Base64.getEncoder().encodeToString(randomStr.getBytes());
        System.out.println("jdkBase64编码后的字符串: " + string);
        String stringDecode = new String(Base64.getDecoder().decode(string));
        System.out.println("jdkBase64解码后的字符串: " + stringDecode);

    }
}
