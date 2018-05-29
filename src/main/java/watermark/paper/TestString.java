package watermark.paper;

public class TestString {
//将s中的第一个s1替换成"xbwd"(薛冰无敌)
	public static void main(String[] args) {
		String s="abcdssjkjk";
		String s1="sj";
		int i=s.indexOf(s1);
		String s2=s.substring(0,i)+"xbwd"
		+s.substring(i+s1.length(),s.length());
		System.out.println(s2);
	}
}
