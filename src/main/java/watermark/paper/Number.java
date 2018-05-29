package watermark.paper;

import java.math.BigDecimal;

public class Number {
public static void main(String[] args) {
	BigDecimal bd = new BigDecimal(50.417);
	BigDecimal bd_ = new BigDecimal(1000000);
	int temp = (int) (bd.multiply(bd_).doubleValue());
	System.out.println(temp);
	temp = temp - temp % 100000;
	double d = temp / 1000000.000000;
	System.out.println(d);
	String str_ = String.valueOf(d) + 0+0+0+0+0;
	System.out.println(str_);
}
}
