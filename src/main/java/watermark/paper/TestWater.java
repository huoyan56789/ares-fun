package watermark.paper;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestWater {

	public static void main(String[] args) {
		String str=readSvg("d:/无敌大魔王.svg");
		/*System.out.println(str);*/
		String newStr = str.replaceAll("<path", "path");// 用来计算path标签的个数
		/*System.out.println(str.length() - newStr.length());*/
		String[] paths = new String[str.length() - newStr.length()];// 此数组存放所有path标签
		String regex = "<path(.*?)/>";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
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
		System.out.println(paths[0]);
		//创建一个图片缓冲区  
		 
		String[] sourceStrArray = paths[0].split(",|[A-Za-z]|\\s[A-Za-z]\\s|\\s");
		int embedCount=0;//溢出器
		BufferedImage image = new BufferedImage(295, 87, BufferedImage.TYPE_INT_BGR);
		int [] imageData=new int[25665];//用来储存读取到的数据
		int nmb=0;
		for(int k=0;k<sourceStrArray.length;k++){
			if(embedCount<5133){
				if(sourceStrArray[k]!=null&&sourceStrArray[k].length()>0){//字符串非空
						BigDecimal bd=new BigDecimal(sourceStrArray[k]);
						BigDecimal bd_=new BigDecimal(1000000);
						int temp=(int)(bd.multiply(bd_).doubleValue()); 
						if(temp<10000000){
							System.out.println(temp);
						}
						System.out.println(temp);
						int singleDigit=temp%10;//获取个位数
						int tensDigit=(temp/10)%10;//获取十位数
						int hundredsDigit=(temp/100)%10;//获取百位数
						int thousandsDigit=(temp/1000)%10;//获取千位数
						int wanDigit=(temp/10000)%10;//获取万位数
						imageData[embedCount*5]=wanDigit;//放入数组
						imageData[embedCount*5+1]=thousandsDigit;//放入数组
						imageData[embedCount*5+2]=hundredsDigit;//放入数组
						imageData[embedCount*5+3]=tensDigit;//放入数组
						imageData[embedCount*5+4]=singleDigit;//放入数组
						embedCount++;			
					}					
			}else{
				break;
			}
		}
		for(int y=0;y<imageData.length;y++){
			if(imageData[y]==1){
				nmb++;
			}
		}
		System.out.println(nmb);
		int imageData_ [][]=new int[295][87];
		int num=-1;
		for (int i = 0; i < 295; i++) {
			   for (int j = 0; j < 87; j++) {
			    num++;
			    imageData_[i][j] = imageData[num];
			    if(imageData_[i][j]==0){
			    	image.setRGB(i, j, 0);
			    }else if(imageData_[i][j]==1){
			    	image.setRGB(i, j, 16777215);//可选择画板255灰度的RGB
			    }
		}
		//输出文件  
		File file_ = new File("d:/test.png");  
		try {  
		    ImageIO.write(image, "png",file_);
		} catch (IOException e) {  
		    e.printStackTrace();  
		}  
		}
	}
	public static String readSvg(String fileName){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String data;
		String s = null;
		try {
			while ((data = br.readLine()) != null) {
				s=data;
			}					
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			 try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
}
