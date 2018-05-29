package watermark.paper;

import java.io.PrintWriter;

public class TestSorage {

	public static void main(String[] arg){ 
	    int[] buf = {0,1,2,3,4,5,6,7,8,10000}; 
	    try{ 
	       PrintWriter out = new PrintWriter("d:/test.txt");       
	       for(int i = 0 ; i < buf.length ; i ++ ){
	    	   out.print(buf[i]+"\r\n");
	       }
	       out.flush();
	       out.close();          
	    }catch(Exception e){ 
	       String s = e.toString(); 
	       System.out.println(s); 
	    } 
	}
}
