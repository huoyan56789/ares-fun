package watermark.paper;/*
package watermark.paper;

*/
/*
 *  功能：解析svg文件，并对svg文件进行操作
 *//*


import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGElement;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class SVGOperate {
	public SVGOperate(JFrame frame_) {
		frame = frame_;
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("数字图像水印算法");
		SVGOperate app = new SVGOperate(frame);

		frame.getContentPane().add(app.createComponents());

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(1024, 700);// 设置窗体大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		int xTemp = (int) (toolkit.getScreenSize().getWidth() - frame.getWidth()) / 2;

		int yTemp = (int) (toolkit.getScreenSize().getHeight() - frame.getHeight()) / 2;

		frame.setLocation(xTemp, yTemp);
		frame.setVisible(true);// 设置窗口可见
	}

	protected JFrame frame;

	protected JButton chooseButton = new JButton("选择图片");
	protected JButton bigButton = new JButton("放大");
	protected JButton smallButton = new JButton("缩小");
	protected JButton rotateButton = new JButton("旋转");
	protected JButton rightButton = new JButton("右移");
	protected JButton downButton = new JButton("下移");
	protected JButton leftButton = new JButton("左移");
	protected JButton upButton = new JButton("上移");
	protected JButton addMarkButton = new JButton("添加水印");
	protected JButton extractMarkButton = new JButton("提取水印");
	protected JButton deleteButton = new JButton("删除图片");
	protected JButton saveButton = new JButton("保存图片");

	protected JLabel label = new JLabel();

	protected JSVGCanvas svgCanvas = new JSVGCanvas();
	SVGDocument svgDocument;// SVGDocument实例
	SVGElement svgRoot;// SVGElement实例
	Element ele;// 通过ID获得的元素
	double xaxis = 1;// 初始化x轴放大倍数
	double yaxis = 1;// 初始化y轴放大倍数
	float rotateAngle = 0;// 旋转角度
	int xIndex = 0;// 横坐标
	int yIndex = 0;// 纵坐标
	int height;// 水印宽度
	int width;// 水印高度
	*/
/*
	 * 私密参数
	 *//*

	int singleStorage = 5;// 定义单个数字所能携带的信息量
	

	public JComponent createComponents() {

		final JPanel panel = new JPanel(new BorderLayout());
		JPanel panel_ = new JPanel(new FlowLayout(FlowLayout.LEFT));

		panel_.add(chooseButton);
		panel_.add(bigButton);
		panel_.add(smallButton);
		panel_.add(rotateButton);
		panel_.add(upButton);
		panel_.add(downButton);
		panel_.add(leftButton);
		panel_.add(rightButton);
		panel_.add(label);
		panel_.add(addMarkButton);
		panel_.add(extractMarkButton);
		panel_.add(deleteButton);
		panel_.add(saveButton);
		panel.add("North", panel_);
		panel.add("Center", svgCanvas);

		// 获取点击事件的横纵坐标
		svgCanvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX() + "  " + e.getY());
				System.out.println(e.getLocationOnScreen());
				System.out.println(svgCanvas.getAlignmentX());
				svgCanvas.getAlignmentX();
				xIndex = e.getX();
				yIndex = e.getY();
			}
		});

		// 选择图片并加载
		chooseButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				JFileChooser fc = new JFileChooser(".");
				int choice = fc.showOpenDialog(panel);
				if (choice == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					try {
						svgCanvas.setURI(f.toURL().toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// 添加水印
		addMarkButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "选择水印");
				File file = jfc.getSelectedFile();
				svgDocument = svgCanvas.getSVGDocument();
				svgRoot = svgDocument.getRootElement();
				Element elePath = (Element) svgRoot.getFirstChild().getFirstChild();
				String dProperty = elePath.getAttributes().getNamedItem("d").getNodeValue();// 获得d属性
				// 根据传入的水印文件得到其灰度数据
				int[][] waterData = getImageGRB(file);
				System.out.println("水印的大小为" + width + "x" + height + "px");
				// 根据水印的灰度值得到水印数据(一个一维二进制数组)
				int[] watermark = convert(waterData);
				*/
/*
				 * 此方法为私密方法
				 *//*

				//对水印数据进行简单的加密
				for (int k = 0; k < watermark.length; k++) {
					int temp=k%8;
					watermark[k]=2*watermark[k]+temp;
				}
				// 得到根据水印数据修改的修改值
				String modifiedValue = modifyProperty(dProperty, watermark);
				// 根据返回的修改值修改d属性
				elePath.setAttribute("d", modifiedValue);
				System.out.println("添加水印成功!");
			}

			*/
/*
			 * 此方法根据传入的d属性和水印数据，对原有属性进行 修改，并将修改后的值返回
			 *//*

			private String modifyProperty(String dProperty, int[] watermark) {
				String[] sourceStrArray = dProperty.split(",|[A-Za-z]|\\s|\\s[A-Za-z]|\\s[A-Za-z]\\s");
				int embedCount = 0;// 溢出器
				String[] path_ = new String[height * width / singleStorage];
				for (int k = 0; k < sourceStrArray.length; k++) {
					if (embedCount < height * width / singleStorage) {
						if (sourceStrArray[k] != null && sourceStrArray[k].length() > 0) {// 字符串非空
							BigDecimal bd = new BigDecimal(sourceStrArray[k]);
							*/
/*
							 * 1000000为私密数据，与singleStorage相关联
							 *//*

							BigDecimal bd_ = new BigDecimal(1000000);
							int temp = (int) (bd.multiply(bd_).doubleValue());
							temp = temp - temp % 100000;
							double d = temp / 1000000.000000;
							String str_ = String.valueOf(d) */
/*+ String.valueOf(watermark[embedCount * singleStorage])
									+ String.valueOf(watermark[embedCount * singleStorage + 1])
									+ String.valueOf(watermark[embedCount * singleStorage + 2])
									+ String.valueOf(watermark[embedCount * singleStorage + 3])
									+ String.valueOf(watermark[embedCount * singleStorage + 4]);*//*
;
							if (embedCount == 0) {
								int index = dProperty.indexOf(sourceStrArray[k]);
								// 将指定位置的字符串换为自己改变后的字符串
								path_[embedCount] = dProperty.substring(0, index) + str_
										+ dProperty.substring(index + sourceStrArray[k].length(), dProperty.length());
							} else {
								int index_ = path_[embedCount - 1].indexOf(sourceStrArray[k]);
								path_[embedCount] = path_[embedCount - 1].substring(0, index_) + str_
										+ path_[embedCount - 1].substring(index_ + sourceStrArray[k].length(),
												path_[embedCount - 1].length());
							}
							embedCount++;
						}
					} else {
						break;
					}
				}
				return path_[embedCount - 1];
			}

			*/
/*
			 * 此方法将传入文件（即水印）的各个像素的灰度转化为0和1 存入一维数组，并将一维数组返回
			 *//*

			private int[] convert(int[][] waterData) {
				int[] watermark = new int[height * width];
				int waterCount = 0;
				for (int i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						if (waterData[i][j] == 255) {// 如果灰度为255
							watermark[waterCount] = 1;
						} else {// 如果灰度为0
							watermark[waterCount] = 0;
						}
						waterCount++;
					}
				}
				return watermark;
			}
			
			*/
/*
			 * 获取水印文件的灰度值
			 *//*

			private int[][] getImageGRB(File file) {
				int[][] result = null;
				try {
					BufferedImage bufImg = ImageIO.read(file);
					height = bufImg.getHeight();
					width = bufImg.getWidth();
					result = new int[width][height];
					for (int i = 0; i < width; i++) {
						for (int j = 0; j < height; j++) {
							int rgb = bufImg.getRGB(i, j);
							*/
/*
							 * System.out.println(bufImg.getRGB(i, j)
							 * &0xFFFFFF);
							 *//*

							int r = (rgb & 0xff0000) >> 16;
							int g = (rgb & 0xff00) >> 8;
							int b = (rgb & 0xff);
							int gray = (int) (r * 0.3 + g * 0.59 + b * 0.11); // 计算灰度值
							result[i][j] = gray;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return result;
			}
		});

		// 提取水印
		extractMarkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "储存水印");
				File file = jfc.getSelectedFile();
				svgDocument = svgCanvas.getSVGDocument();
				svgRoot = svgDocument.getRootElement();
				Element elePath = (Element) svgRoot.getFirstChild().getFirstChild();
				String dProperty = elePath.getAttributes().getNamedItem("d").getNodeValue();
				// 根据d属性得到一维数组(水印数据)
				width=295;//设置水印宽度
				height=87;//设置水印高度		
				int[] imageData = getData(dProperty,width,height);				
				//对水印数据进行解密置换
				for (int k = 0; k < imageData.length; k++) {
					int temp=k%8;
					imageData[k]=(imageData[k]-temp)/2;
				}
				
				// 根据一维数组和传入文件在文件中创建水印（格式为png）
				drawMark(imageData, file,width,height);
			}

			*/
/*
			 * 此方法根据传入的d属性得到一个一维数组
			 *//*

			
			private int[] getData(String dProperty,int width_,int height_) {
				String[] sourceStrArray = dProperty.split(",|[A-Za-z]|\\s|\\s[A-Za-z]|\\s[A-Za-z]\\s");
				int embedCount = 0;// 溢出器
				int[] imageData = new int[width_ * height_];// 用来储存读取到的数据
				for (int k = 0; k < sourceStrArray.length; k++) {
					if (embedCount < width_ * height_ / singleStorage) {
						if (sourceStrArray[k] != null && sourceStrArray[k].length() > 0) {// 字符串非空
							BigDecimal bd = new BigDecimal(sourceStrArray[k]);
							BigDecimal bd_ = new BigDecimal(1000000);
							double d=bd.multiply(bd_).doubleValue();
							int temp = (int) d;		
							if((double)temp==d){
								int wanDigit = (temp % 100000 )/ 10000;// 获取万位数
								imageData[embedCount * singleStorage] = wanDigit;// 放入数组	
								int thousandsDigit = (temp % 10000 )/ 1000;// 获取千位数
								imageData[embedCount * singleStorage + 1] = thousandsDigit;// 放入数组
								int hundredsDigit =( temp % 1000 )/ 100;// 获取百位数
								imageData[embedCount * singleStorage + 2] = hundredsDigit;// 放入数组
								int tensDigit = (temp % 100) / 10;// 获取十位数				
								imageData[embedCount * singleStorage + 3] = tensDigit;// 放入数组
								int singleDigit = temp % 10;// 获取个位数
								imageData[embedCount * singleStorage + 4] = singleDigit;// 放入数组
								
								embedCount++;
							}else{
								imageData[embedCount * singleStorage] = 0;
								imageData[embedCount * singleStorage+1] = 0;
								imageData[embedCount * singleStorage+2] = 0;
								imageData[embedCount * singleStorage+3] = 0;
								imageData[embedCount * singleStorage+4] = 0;
								
								embedCount++;
							}
							
						}
					} else {
						break;
					}
				}
				return imageData;
			}
			
			*/
/*
			 * 此方法根据传入的一维数组在相应的文件中生成水印（格式为png)
			 *//*

			private void drawMark(int[] imageData, File file,int width_,int height_) {
				// 画板大小与水印大小一致（水印大小在添加时可得知）
				BufferedImage image = new BufferedImage(width_, height_, BufferedImage.TYPE_INT_BGR);
				int num = -1;
				for (int i = 0; i < width_; i++) {
					for (int j = 0; j < height_; j++) {
						num++;
						if (imageData[num] == 1) {
							image.setRGB(i, j, 16777215);// 水印采用可选择画板，其255灰度的RGB分量为16777215
						} else {
							image.setRGB(i, j, 0);
						}
					}
					// 输出文件
					try {
						ImageIO.write(image, "png", file);// 以png格式输出
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("水印提取成功！");
			}
		});

		// 删除图片
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				svgDocument = svgCanvas.getSVGDocument();
				svgRoot = svgDocument.getRootElement();
				svgRoot.removeChild(ele);
				svgCanvas.setSVGDocument(svgDocument);
			}
		});

		// 保存图片
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "保存文件");
				File file = jfc.getSelectedFile();
				svgDocument = svgCanvas.getSVGDocument();
				TransformerFactory tfac = TransformerFactory.newInstance();
				try {
					Transformer tra = tfac.newTransformer();
					DOMSource doms = new DOMSource(svgDocument);
					FileOutputStream outstream = new FileOutputStream(file);
					StreamResult sr = new StreamResult(outstream);
					tra.transform(doms, sr);
				} catch (TransformerConfigurationException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (TransformerException e) {
					e.printStackTrace();
				}

			}
		});

		*/
/**
		 * 通过ID单独对某一个图形单独进行放大、缩小、旋转、平移等操作
		 *//*

		// 放大
		bigButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				double times = 0.2;// 设置增大倍数
				xaxis = xaxis + times;
				yaxis = yaxis + times;
				svgDocument = svgCanvas.getSVGDocument();
				ele.setAttribute("transform", "scale(" + xaxis + ',' + yaxis + ")");
				svgCanvas.setSVGDocument(svgDocument);
			}
		});
		// 缩小
		smallButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				double times = 0.2;// 设置缩小倍数
				xaxis = xaxis - times;
				yaxis = yaxis - times;
				svgDocument = svgCanvas.getSVGDocument();
				ele.setAttribute("transform", "scale(" + xaxis + "," + yaxis + ")");
				svgCanvas.setSVGDocument(svgDocument);

			}
		});
		// (旋转（不设置旋转中心默认以左上角为原点旋转）
		rotateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int degree = 15;// 设置旋转角度
				*/
/*String center = " 80 80)";// 设置旋转中心
*//*

				String center = " 220 220)";// 设置旋转中心
				rotateAngle = rotateAngle + degree;
				svgDocument = svgCanvas.getSVGDocument();
				ele.setAttribute("transform", "rotate(" + rotateAngle + center);
				svgCanvas.setSVGDocument(svgDocument);

			}
		});
		// 左移
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int move = 50;// 设置左移距离
				xIndex = xIndex - move;
				svgDocument = svgCanvas.getSVGDocument();
				ele.setAttribute("transform", "translate(" + xIndex + "," + yIndex + ")");
				svgCanvas.setSVGDocument(svgDocument);
			}
		});
		// 右移
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int move = 50;// 设置右移距离
				xIndex = xIndex + move;
				svgDocument = svgCanvas.getSVGDocument();
				ele.setAttribute("transform", "translate(" + xIndex + "," + yIndex + ")");
				svgCanvas.setSVGDocument(svgDocument);
			}
		});
		// 上移
		upButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int move = 30;// 设置上移距离
				yIndex = yIndex - move;
				svgDocument = svgCanvas.getSVGDocument();
				ele.setAttribute("transform", "translate(" + xIndex + "," + yIndex + ")");
				svgCanvas.setSVGDocument(svgDocument);
			}
		});
		// 下移
		downButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int move = 30;// 设置下移距离
				yIndex = yIndex + move;
				svgDocument = svgCanvas.getSVGDocument();
				ele.setAttribute("transform", "translate(" + xIndex + "," + yIndex + ")");
				svgCanvas.setSVGDocument(svgDocument);
			}
		});

		// 设置JSVGCanvas监听器
		svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {
			public void documentLoadingStarted(SVGDocumentLoaderEvent e) {
				label.setText("图片加载中...");
			}

			public void documentLoadingCompleted(SVGDocumentLoaderEvent e) {
				label.setText("图片加载完成!");
				svgDocument = svgCanvas.getSVGDocument();
				// 根据ID绑定元素!!!(我图片的元素ID为SVGDemo)
				// 根据ID绑定元素!!!(我图片的元素ID为SVGDemo)
				// 根据ID绑定元素!!!(我图片的元素ID为SVGDemo)
				ele = svgDocument.getElementById("SVGDemo");
			}
		});

		svgCanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter() {
			public void gvtBuildStarted(GVTTreeBuilderEvent e) {
				label.setText("开始载入...");
			}

			public void gvtBuildCompleted(GVTTreeBuilderEvent e) {
				label.setText("载入成功!");
				frame.pack();
			}
		});

		svgCanvas.addGVTTreeRendererListener(new GVTTreeRendererAdapter() {
			public void gvtRenderingPrepare(GVTTreeRendererEvent e) {
				label.setText("打底开始...");
			}

			public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
				label.setText("图片编辑中...");
			}
		});

		return panel;
	}

}
*/
