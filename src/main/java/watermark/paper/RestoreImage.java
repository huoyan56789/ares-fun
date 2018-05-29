package watermark.paper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//根据每个像素的灰度值还原图像
public class RestoreImage {

	public static void main(String[] args) {
		//创建一个图片缓冲区  
		BufferedImage image = new BufferedImage(295, 87, BufferedImage.TYPE_INT_BGR); 
		File file=new File("d:/temp.txt");
		BufferedReader br;
		int [] imageNumber=new int[25665];
		int count=0;//字符串数组计数器
		try {
			br = new BufferedReader(new FileReader(file));
			String data;
			try {
				while((data = br.readLine()) != null){
					int temp=count%9;
					imageNumber[count]=Integer.parseInt(data)-temp;
					count++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		}
		try{ 
		       PrintWriter out = new PrintWriter("d:/temp.txt");//将像素数据存入txt    
		       for(int i = 0 ; i < imageNumber.length ; i ++ ){
		    	   out.print(imageNumber[i]+"\r\n");
		       }
		       out.flush();
		       out.close();          
		    }catch(Exception e){ 
		       String s = e.toString(); 
		       System.out.println(s); 
		    } 
		int imageData [][]=new int[295][87];
		int num=-1;
		for (int i = 0; i < 295; i++) {
			   for (int j = 0; j < 87; j++) {
			    num++;
			    imageData[i][j] = imageNumber[num];
			    if(imageData[i][j]==0){
			    	image.setRGB(i, j, 0);
			    }else if(imageData[i][j]==1){
			    	image.setRGB(i, j, 16777215);
			    }
		}
        //输出文件  
        File file_ = new File("d:/水印——.png");  
        try {  
        	ImageIO.write(image, "png",file_);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}
}
}
