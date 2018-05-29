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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SVGAnalysis {
	public SVGAnalysis(JFrame frame_) {
		frame = frame_;
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("SVG解析");
		SVGAnalysis app = new SVGAnalysis(frame);

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
				int move = 0;// 设置上移距离
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
