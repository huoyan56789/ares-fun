package algorithm.encrypt;

/**
 * @author Ares
 * @date 2018/5/21 9:21
 */
public class Base64
{
    public static void main(String[] args)
    {
        String s = "r32rqfjew9gjngignagsgn32f832nfa4hqtqywtwywhyw";
        String str = baseEncrypt(s);
        System.out.println(str);
    }

    public static String baseEncrypt(String s){
        final char [] chars = {
                'A','B','C','D','E','F','G',
                'H','I','J','K','L','M','N',
                'O','P','Q','R','S','T',
                'U','V','W','X','Y','Z',
                'a','b','c','d','e','f','g',
                'h','i','j','k','l','m','n',
                'o','p','q','r','s','t',
                'u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9','*','/'
        };
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
        {
            stringBuffer.append(String.format("%08d",Integer.parseInt(Integer.toBinaryString(s.charAt(i)))));
        }
        int length = stringBuffer.length();
        stringBuffer = length % 24 == 0 ? stringBuffer:(length % 24 == 8 ? stringBuffer.append("0000000000000000"):stringBuffer.append("00000000"));
        StringBuffer tempStr = new StringBuffer();
        for (int i = 0; i < stringBuffer.length(); i+= 6)
        {
            tempStr.append(chars[Integer.parseInt(stringBuffer.substring(i, i+6), 2)]);
        }
        s = new String(tempStr);
        s = length % 24 == 0 ? s:(length % 24 == 8 ? s.substring(0, s.length()-2) + "==":s.substring(0, s.length()-1) + "=");
        return s;
    }
}
