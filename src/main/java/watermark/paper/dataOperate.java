package watermark.paper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dataOperate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/老虎.svg")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String data = null;
		try {
			while ((data = br.readLine()) != null) {
				System.out.println(data); // 输出获得内容
				String newStr = data.replaceAll("<path", "path");// 用来计算path标签的个数
				String[] paths = new String[data.length() - newStr.length()];// 此数组存放所有path标签
				String regex = "<path(.*?)>(.*?)</path>";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(data);
				int count = 0;// 用来储存path标签
				while (m.find()) {
					String regEx = "M(.*?)\"";
					Pattern pattern = Pattern.compile(regEx);
					Matcher matcher = pattern.matcher(m.group(0));
					while (matcher.find()) {
						// 将d属性存入paths
						paths[count] = matcher.group(0).substring(0, matcher.group(0).length() - 2);
					}
					count++;
				}
				/*System.out.println(paths[0]);*/
				//读取水印数据并存入一维数组
				int [] [] waterData=getImageGRB("d:/嵌入水印.gif");
				int [] watermark=new int[3000];
				int waterCount=0;
				for(int i=0;i<100;i++){
					for(int j=0;j<30;j++){
						if(waterData[i][j]==255){
							watermark[waterCount]=1;
						}else{
							watermark[waterCount]=0;
						}				
						waterCount++;
					}
				}
				String[] sourceStrArray = paths[0].split(",|[A-Za-z]|\\s[A-Za-z]\\s|\\s");
				int embedCount=0;//溢出器
				String [] path_ =new String[3000];
				for(int k=0;k<sourceStrArray.length;k++){
					if(embedCount<3000){
						if(sourceStrArray[k]!=null&&sourceStrArray[k].length()>0){//字符串非空
							int temp=(int)(Double.parseDouble(sourceStrArray[k])*10000);
							int mod=temp%10;
							temp=temp-mod+watermark[embedCount];							
							double d=temp/10000.0000;
							String str_=String.valueOf(d);
							System.out.println(str_);
							if(embedCount==0){
								path_[0]=paths[0].replace(sourceStrArray[k], str_);
							}else{
								path_[embedCount]=path_[embedCount-1].replace(sourceStrArray[k], str_);	
							}	
							embedCount++;
						}	
						
					}else{
						break;		
					}		
				}				
				/*System.out.println(path_[embedCount-1]);*/
				
				// 水印为 100X30 像素
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int[][] getImageGRB(String filePath) {
        File file  = new File(filePath);
        int[][] result = null;
        if (!file.exists()) {
             return result;
        }
        try {
             BufferedImage bufImg = ImageIO.read(file);
             int height = bufImg.getHeight();  
             int width = bufImg.getWidth();
             result = new int[width][height];
             for (int i = 0; i < width; i++) {
                  for (int j = 0; j < height; j++) {
                        int rgb = bufImg.getRGB(i, j);
                        /*System.out.println(bufImg.getRGB(i, j) & 0xFFFFFF);*/
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
