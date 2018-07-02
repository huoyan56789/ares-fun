/**
 * @author Ares
 * @date 2018/5/15 10:47
 */
public class Grammar
{
    public static void main(String[] args)
    {
        int num = 127;
        System.out.println(num);
        String binaryString = Integer.toBinaryString(num);
        int binaryInt = Integer.parseInt(binaryString);
        System.out.println(String.format("%08d",binaryInt));

        int numToRight = num >> 1;
        System.out.println(numToRight);
        System.out.println(String.format("%08d",Integer.parseInt(Integer.toBinaryString(numToRight))));

        int numToLeft = numToRight << 1;
        System.out.println(numToLeft);
        System.out.println(String.format("%08d",Integer.parseInt(Integer.toBinaryString(numToLeft))));

        System.out.println("---------------------------------");

        num = -127;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));

        numToRight = num >> 1;
        System.out.println(numToRight);
        System.out.println(Integer.toBinaryString(numToRight));

        numToLeft = numToRight << 1;
        System.out.println(numToRight);
        System.out.println(Integer.toBinaryString(numToRight));

        System.out.println("---------------------------------");

        num = 63;
        System.out.println(num);
        binaryString = Integer.toBinaryString(num);
        binaryInt = Integer.parseInt(binaryString);
        System.out.println(String.format("%08d",binaryInt));

        numToRight = num >>> 1;
        System.out.println(numToRight);
        System.out.println(String.format("%08d",Integer.parseInt(Integer.toBinaryString(numToRight))));

        System.out.println("---------------------------------");

        num = -63;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num));

        numToRight = num >>> 1;
        System.out.println(numToRight);
        System.out.println(Integer.toBinaryString(numToRight));

    }
}
