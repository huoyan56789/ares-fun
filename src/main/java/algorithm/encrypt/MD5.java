package algorithm.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.Date;

/**
 * @author Ares
 * @date 2018/1/2 17:04
 */
public class MD5
{

    private static Logger logger = LoggerFactory.getLogger(MD5.class);
    /**
     * 根据传入的参数生成鉴权参数
     *
     * @param paramOne
     * @param paramTwo
     *
     * @return
     */
    public static String authorityParameter(String paramOne, String paramTwo)
    {

        StringBuilder stringBuilder = new StringBuilder(32);

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest((paramOne + paramTwo + new Date()).getBytes("utf-8"));

            for (byte b : array)
            {
                stringBuilder.append(Integer.toHexString((b & 0xFF) | 0x100).toUpperCase().substring(1, 3));
            }
        } catch (Exception e)
        {
            throw new RuntimeException("生成鉴权参数出错");
        }

        return stringBuilder.toString();
    }

    public static String getMD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    public static void main(String[] args)
    {
        String str = getMD5("ares");
        System.out.println(str);
    }
}
