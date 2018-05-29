package watermark.paper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/*得到水印每个像素的灰度值*/
public class ReadGif {

	public static void main(String[] args) {
		int [] [] data=getImageGRB("d:/扬州大学.gif");
		int [] watermark=new int[25665];
		
		
		int count=0;
		for(int i=0;i<295;i++){
			for(int j=0;j<87;j++){
				if(data[i][j]==255){
					watermark[count]=1;
				}else{
					watermark[count]=0;
				}				
				count++;
			}
		}
		int nmb=0;
		for(int k=0;k<watermark.length;k++){
			if(watermark[k]==1){
				nmb++;
			}	
		}
	    System.out.println(nmb);
		for (int k = 0; k < watermark.length; k++) {
			int temp=k%9;
			watermark[k]=watermark[k]+temp;
		}
		try{ 
		       PrintWriter out = new PrintWriter("d:/temp.txt");//将像素数据存入txt    
		       for(int i = 0 ; i < watermark.length ; i ++ ){
		    	   out.print(watermark[i]+"\r\n");
		       }
		       out.flush();
		       out.close();          
		    }catch(Exception e){ 
		       String s = e.toString(); 
		       System.out.println(s); 
		    } 
			
    }
	 /**
     * 获取图片RGB数组
     * @param filePath
     * @return
     */
public static int[][] getImageGRB(String filePath) {
          File file  = new File(filePath);
          int[][] result = null;
          if (!file.exists()) {
               return result;
          }
          try {
               BufferedImage bufImg = ImageIO.read(file);
               int height = bufImg.getHeight();  
               /*System.out.println(height);*/
               int width = bufImg.getWidth();
               /*System.out.println(width);*/
               result = new int[width][height];
               for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                          int rgb = bufImg.getRGB(i, j);
                         /* System.out.println(bufImg.getRGB(i, j) & 0xFFFFFF);*/
                          int r = (rgb & 0xff0000) >> 16;
                          int g = (rgb & 0xff00) >> 8;
                          int b = (rgb & 0xff);
                          int gray = (int)(r * 0.3 + g * 0.59 + b * 0.11); //计算灰度值
                          result[i][j]=gray;
               }
             }
               
          } catch (IOException e) {
               e.printStackTrace();
          }
          
          return result;
    }

}
