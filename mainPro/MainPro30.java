package mainPro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.tree.TreeNode;

import DrawTree.DrawStandardizedTree;
import formulaParser.*;
import pptlsat.PPTLSATRunTime;
import stanfordnlp.Demo;
import stanfordnlp.DependencyDemo;

/**
 * @author Administrator
 *
 */
public class MainPro30 {
	
	private JFrame frame;//主框架
	private JPanel mainpanel;//主面板，与frame一样大小
	
	private JPanel barPanel;//工具栏的面板
	
	private JPanel bodypanel;//工具栏下面的所有面板，包括左边的leftpanel，和有边的rightpanel
	private JPanel leftpanel;//
	private JPanel rightpanel;//
	
	private JPanel uppanel;//
	private JPanel downpanel;//
	
	private JPanel NutureTextpanel;//自然语言编辑区
	private JPanel EditButtonpanel;//公式编辑按钮区
	private JPanel Formulapanel;//公式生成区
	
	private JPanel shengchengButtonpanel;//公式生成按钮Panel
	private JPanel yanzhengButtonpanel;//公式验证按钮Panel
	
	JPanel centerBMP ;  //bmp图片
	
	public JScrollPane rightscroll;
	
	private JMenuItem newProjectItem;//菜单栏
	private JMenuItem importProjectItem;//菜单栏
	private JMenuItem exportProjectItem;//菜单栏
	private JMenuItem exitItem;//菜单栏
	
	private JToolBar bar1;//工具条
	private JToolBar bar2;//工具条
	private JToolBar bar3;//工具条
	private JToolBar bar4;//工具条
	
	private JToolBar formulabar;//公式编辑工具条
	
	
	private JTree tree = null;
	
	private Connection conn;//连接数据库的链接
	
	private int level = 0;
	
	private MainPro30 mainPro;
	
	private JButton[] button = new JButton[10];
	
	
	JFrame authority_frame;
	JLabel titallab;
	JLabel midlab;
	JLabel reglab;
//	JTextField pwdjtf;
	JPasswordField pwdjpf;
	JPasswordField repwdjpf;
	JButton okbtn;
	JButton canclebtn;
	
	JLabel jLabel;
	JLabel shuruxingzhi;
	JLabel fill_label;
	JLabel bianjixingzhi;
	
	JLabel zhuangtaizhuanhuantu;
	
	JButton shengchengbtn;
	JButton yanzhengbtn;
	JButton Fine_grained_btn;
	JButton Draw_DependencyTree_btn;
	JButton File_generate_pptl;
	
	JTextArea nutureEditor ;
	JTextArea formulaEditor;
	JTextArea FG_formulaEditor;
	String  formula;
	
	HashMap<String,String> hashmap;
	
	Image bg, bg2;
	
	
	
	/** 
	 * 
	 *语法树生成
	 */   
	
	JButton draw_tree;
	JButton view_tree;
	

	public MainPro30() throws Exception {
		Locale.setDefault(Locale.ENGLISH);  //英文
		initMainForm();
		
}
	
	
	public void initMainForm() throws Exception {
		mainPro = this;

		frame = new JFrame();

//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/mainIcon.jpg"));
		frame.setTitle("NL2PPTL");// 窗体标签
		frame.setSize(400, 210);// 窗体大小
		frame.setResizable(true);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);// 显示窗体
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "要退出该程序吗？",
						"友情提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				} else {
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}
			}
		});

		JMenuBar menubar1 = new JMenuBar();
		mainpanel = new JPanel();
		frame.setContentPane(mainpanel);
		frame.setJMenuBar(menubar1);
//		JMenu projectManagementMenu = new JMenu("项目管理");
		JMenu settingMenu = new JMenu("Setting");
		JMenu helpMenu = new JMenu("Help");
		menubar1.add(settingMenu);
		menubar1.add(helpMenu);
		
		
		
		exitItem = new JMenuItem("Exit");
		JMenuItem item4 = new JMenuItem("用户手册");
		item4.addActionListener(new OpenHelperItemListener());
		helpMenu.add(item4);
		

		button[0] = new JButton("prj");
		button[1] = new JButton("sometimes<>");
		button[2] = new JButton("always[]");
		button[3] = new JButton("fin");
		button[4] = new JButton("next ()");
		button[5] = new JButton("->");
		button[6] = new JButton("&&");
		button[7] = new JButton("||");
		button[8] = new JButton("(");
		button[9] = new JButton(")");
		ButtonToolListener buttonToolListener = new ButtonToolListener();
		for (int i = 0; i < button.length; i++) {
//			button[i].setEnabled(false);
			button[i].addActionListener(buttonToolListener);
		}
		bar1 = new JToolBar(SwingConstants.CENTER);
		bar1.setBackground(new Color(159, 182, 205));
		bar1.add(button[0]);
		bar1.addSeparator();
		bar1.add(button[1]);
		bar1.addSeparator();
		
		bar2 = new JToolBar(SwingConstants.CENTER);
		bar2.setBackground(new Color(159, 182, 205));
		bar2.add(button[2]);
		bar2.addSeparator();
		bar2.add(button[3]);
		bar2.addSeparator();
		bar2.add(button[4]);
		bar2.addSeparator();
		bar2.add(button[5]);
		bar2.addSeparator();
		bar2.setToolTipText("标段操作");
		
		bar3 = new JToolBar(SwingConstants.CENTER);
		bar3.setBackground(new Color(159, 182, 205));
		bar3.add(button[6]);
		bar3.addSeparator();
		bar3.add(button[7]);
		

		bar4 = new JToolBar(SwingConstants.CENTER);
		bar4.setBackground(new Color(159, 182, 205));
		bar4.add(button[8]);
		bar4.addSeparator();
		bar4.add(button[9]);
		
		BorderLayout bord = new BorderLayout();
		mainpanel.setLayout(bord);

		barPanel = new JPanel();
		barPanel.setLayout(new BoxLayout(barPanel, BoxLayout.X_AXIS));
		barPanel.setBackground(new Color(159, 182, 205));
		barPanel.add(bar1);
		barPanel.add(bar2);
		barPanel.add(bar3);

		barPanel.setPreferredSize(new Dimension(barPanel.getWidth(), 35));

		mainpanel.add("North", barPanel);

		bodypanel = new JPanel();
		bodypanel.setBackground(new Color(188, 210, 238));
		mainpanel.add("Center", bodypanel);

		leftpanel = new JPanel();
		rightpanel = new JPanel();
		rightpanel.setLayout(new BorderLayout());
		JSplitPane centerSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftpanel, rightpanel);
		
		
		NutureTextpanel=new JPanel(new GridLayout(1, 1));
		EditButtonpanel=new JPanel(new GridLayout(1, 1));
		Formulapanel=new JPanel(new GridLayout(1, 1));
		
		downpanel=new JPanel();
		uppanel=new JPanel();
		
		JButton button = new JButton("编辑公式");
		nutureEditor = new JTextArea();
		
		/**
		 * 增加滚动条2-22
		 * 
		 * */
		 JScrollPane js=new JScrollPane(nutureEditor);
		//分别设置水平和垂直滚动条自动出现
		js.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		
		formulaEditor= new JTextArea();
		FG_formulaEditor= new JTextArea();
		nutureEditor.setLineWrap(true);
		formulaEditor.setLineWrap(true);
		
		
		
		/**
		 * 增加滚动条2-22
		 * 
		 * */
		 JScrollPane js_formulaEditor=new JScrollPane(formulaEditor);
		//分别设置水平和垂直滚动条自动出现
		 js_formulaEditor.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		js_formulaEditor.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		FG_formulaEditor.setLineWrap(true);
		
		/**
		 * 增加滚动条2-22
		 * 
		 * */
		 JScrollPane js_FG_formulaEditor=new JScrollPane(FG_formulaEditor);
		//分别设置水平和垂直滚动条自动出现
		 js_FG_formulaEditor.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 js_FG_formulaEditor.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		NutureTextpanel.add(nutureEditor);
		
		EditButtonpanel.setLayout(new BoxLayout(EditButtonpanel, BoxLayout.X_AXIS));
		EditButtonpanel.setBackground(new Color(159, 182, 205));
		EditButtonpanel.add(bar1);
		EditButtonpanel.add(bar2);
		EditButtonpanel.add(bar3);
		EditButtonpanel.add(bar4);
		EditButtonpanel.setPreferredSize(new Dimension(EditButtonpanel.getWidth(), 35));

		/** 
		 * 
		 *2022-1 细粒度分析
		 *
		 */   
		
		shengchengbtn = new JButton("PPTL Generation");
		Fine_grained_btn = new JButton("Fine grained");
		Fine_grained_btn.addActionListener(buttonToolListener);
		Draw_DependencyTree_btn = new JButton("Dependency Tree");
		Draw_DependencyTree_btn.addActionListener(buttonToolListener);
		
		
		
		yanzhengbtn = new JButton("Determination of Formula Satisfiability");
		shengchengbtn.addActionListener(buttonToolListener);
		yanzhengbtn.addActionListener(buttonToolListener);
		
		
		/** 
		 * 
		 *2021-9新加语法树绘制
		 *
		 */   
		draw_tree= new JButton("Syntax tree");
		draw_tree.addActionListener(buttonToolListener);
		
		view_tree= new JButton("Binary tree");
		view_tree.addActionListener(buttonToolListener);
		
		File_generate_pptl= new JButton("Upload File");
		File_generate_pptl.addActionListener(buttonToolListener);
		
		shengchengButtonpanel = new JPanel();
		yanzhengButtonpanel = new JPanel();
		shengchengButtonpanel.setLayout(new BorderLayout());
		yanzhengButtonpanel.setLayout(new BorderLayout());
		
		
		
		/** 
		 * 
		 *2021-9新加语法树绘制功能
		 *2022-1添加细粒度分析功能 FG_formulaEditor Fine_grained_btn
		 */ 
		
		yanzhengButtonpanel.add(view_tree,BorderLayout.CENTER);
		
		
		shuruxingzhi=new JLabel("Properties Description:");
		fill_label=new JLabel("  ");
		
		bianjixingzhi=new JLabel("PPTL Formula:");
		zhuangtaizhuanhuantu=new JLabel("State Transition Diagram :");
		
		
		shengchengButtonpanel.add(shuruxingzhi,BorderLayout.WEST);
		shengchengButtonpanel.add(draw_tree,BorderLayout.CENTER);
		shengchengButtonpanel.add(Draw_DependencyTree_btn,BorderLayout.EAST);
		shengchengButtonpanel.add(File_generate_pptl,BorderLayout.WEST);
		shengchengButtonpanel.add(shengchengbtn,BorderLayout.CENTER);
		shengchengButtonpanel.add(Fine_grained_btn,BorderLayout.EAST);
		shengchengButtonpanel.setLayout(new GridLayout(2,3));
		
		
		yanzhengButtonpanel.add(bianjixingzhi,BorderLayout.WEST);
		yanzhengButtonpanel.add(yanzhengbtn,BorderLayout.EAST);
		
		//Formulapanel.add(formulaEditor);
		Formulapanel.add(js_formulaEditor);
		//Formulapanel.add(FG_formulaEditor);
		Formulapanel.add(js_FG_formulaEditor);
		
		Formulapanel.setLayout(new GridLayout(2,1));
		
		uppanel.setLayout(new BorderLayout());
		uppanel.add(shengchengButtonpanel,BorderLayout.NORTH);
		uppanel.add(NutureTextpanel,BorderLayout.CENTER);
		
		downpanel.setLayout(new BorderLayout());
		downpanel.add(yanzhengButtonpanel,BorderLayout.NORTH);
		downpanel.add(Formulapanel,BorderLayout.CENTER);
		downpanel.add(EditButtonpanel,BorderLayout.SOUTH);
		
		leftpanel.setLayout(new GridLayout(2, 1,10,10));
		
		leftpanel.add(uppanel);
		leftpanel.add(downpanel);
		
		
		jLabel = new JLabel("");
		
		rightpanel.add(zhuangtaizhuanhuantu,BorderLayout.NORTH);
		rightpanel.add(jLabel,BorderLayout.CENTER);
		
		
		
		
		centerSplit.setDividerLocation(300);
		
		
		rightscroll = new JScrollPane();
		
//		rightpanel.setBackground(Color.ORANGE);
		/*
		 * 由于左边的树形结构需要从数据库查询数据，可能速度比较慢，或者加载失败
		 * 所以新建一个swing分发线程来加载左边的树形结构
		 */
		bodypanel.setLayout(new GridLayout(1, 2,100,100));
		bodypanel.setBackground(Color.white);
		bodypanel.add(centerSplit);
		bodypanel.updateUI();
	}
	public static String file_hashmap= "";
	public static String PPTLformula_Fine_grained_discriptString= "";
	public static String PPTLformula_discriptString= "";
	
	class ButtonToolListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e1) {

					if(e1.getSource() == shengchengbtn){
						
						file_hashmap= "";
						PPTLformula_Fine_grained_discriptString= "";
						PPTLformula_discriptString= "";
								
		        		String discript=nutureEditor.getText();
		        		System.out.println("discript="+discript);
		        		
		        		Thread thread = null;
		        		thread = new Thread(new Runnable() {
							
							@Override
							public void run() {
								try {
						
									String[] pretext = discript.split("\n");
									if(pretext.length>1)
									{
							        for(int i=0;i<pretext.length;i++)
							        {
									hashmap=FormulaParser.main(new String[]{pretext[i]});
									System.out.println("Mainpro中的hashmap值"+hashmap);
									String discriptString="";
									for (String key : hashmap.keySet()) {
										if(key.equals("PPTLformula"))
										{
											PPTLformula_discriptString=PPTLformula_discriptString+"("+hashmap.get(key)+");";
										}
										if(key.equals("PPTLformula_Fine_grained"))
										{
											PPTLformula_Fine_grained_discriptString=PPTLformula_Fine_grained_discriptString+hashmap.get(key)+"\n";
											break;
										}
										System.out.println(key+" "+hashmap.get(key));
										discriptString+=key+": "+hashmap.get(key)+"\n";
									}
									file_hashmap = file_hashmap+discriptString+"\n";
				
							        }
							        System.out.println("file_hashmap中的file_hashmap值"+file_hashmap);
									}
									else
									{
										hashmap=FormulaParser.main(new String[]{discript});
										System.out.println("Mainpro中else的hashmap值"+hashmap);
										String discriptString="";
										for (String key : hashmap.keySet()) {
											if(key.equals("PPTLformula"))
											{
												PPTLformula_discriptString=PPTLformula_discriptString+"("+hashmap.get(key)+");";
											}
											if(key.equals("PPTLformula_Fine_grained"))
											{
												PPTLformula_Fine_grained_discriptString=PPTLformula_Fine_grained_discriptString+hashmap.get(key)+"\n";
												break;
											}
											System.out.println(key+" "+hashmap.get(key));
											discriptString+=key+": "+hashmap.get(key)+"\n";
										}
										file_hashmap = file_hashmap+discriptString+"\n";
									}
								} catch (ParseException e1) {
										e1.printStackTrace();
										System.out.println("在这里显示错误1");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
							}
						});
		        		thread.start();
		        		try {
		                    thread.join();
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
		        		String discriptString="";
		        		//System.out.println("hashmap= "+hashmap);
		        		if(hashmap==null) {	
		        		 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Formula generation failed.", "System Prompt", JOptionPane.INFORMATION_MESSAGE);
		        		}
		        		System.out.println("运行到了这里！/////*****************");
						if(!file_hashmap.equals("")&&file_hashmap!=null) {
							formulaEditor.setText("");
		        			formulaEditor.setText(file_hashmap);
		        			formulaEditor.setCaretPosition(file_hashmap.length());  //刷新formula
		        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Formula generation completed.", "System Prompt", JOptionPane.INFORMATION_MESSAGE);
		        		}else
		        		{
		        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Formula generation failed.", "System Prompt", JOptionPane.INFORMATION_MESSAGE);
		        		}
						thread.stop();
					}
					
					
					/** 
					 * 
					 *2021-9新加语法树绘制功能********************************************************
					 *
					 */
					else if(e1.getSource() == draw_tree){ 
						String natural_language=nutureEditor.getText();
						Demo demo = new Demo(natural_language);
						Demo.main(null);
						
					}
					
					/** 
					 * 
					 *2021-12新加标准语法树绘制功能********************************************************
					 *
					 */
					else if(e1.getSource() == view_tree){ 
						DrawStandardizedTree demo = new DrawStandardizedTree();
						demo.main(null);
						
					}
					/** 
					 * 
					 ***2022-1添加依存树绘制功能********************************************************************************
					 *
					 */
					else if(e1.getSource() == Draw_DependencyTree_btn){ 
						String natural_language=nutureEditor.getText();
						DependencyDemo dependencydemo = new DependencyDemo(natural_language);
						dependencydemo.main(null);
					}
					
					
					/** 
					 * 
					 *2022-1新加细化内容功能********************************************************
					 *
					 */
					else if(e1.getSource() == Fine_grained_btn){ 			
						String FG_discriptString=PPTLformula_Fine_grained_discriptString;
						if(!FG_discriptString.equals("")&&FG_discriptString!=null) {	
		        			FG_formulaEditor.setText(FG_discriptString);
		        			FG_formulaEditor.setCaretPosition(FG_discriptString.length());  //刷新formula
		        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Fine_grained Formula generation completed.", "System Prompt", JOptionPane.INFORMATION_MESSAGE);
		        		}else
		        		{
		        			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Fine_grained Formula generation failed.", "System Prompt", JOptionPane.INFORMATION_MESSAGE);
		        		}
					}
						
					/** 
					 * 
					 ***********************************************************************************
					 *
					 */
					
					
					/** 
					 * 
					 *2022-1新加细化内容功能********************************************************
					 *
					 */
					else if(e1.getSource() == File_generate_pptl){
						try {
							Devload.main(null);
							String File_upload_string = Devload.file_input_string;
					                System.out.println("2读取内容"+"\n"+File_upload_string);
					        nutureEditor.setText(File_upload_string);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
						
					/** 
					 * 
					 ***********************************************************************************
					 *
					 */
					
					
					
					else if(e1.getSource() == yanzhengbtn){  //可满足性判定
			          PPTLSATRunTime pptlSATRunTime =new PPTLSATRunTime();
			          System.out.println("pptlSATRunTime : "+ PPTLformula_discriptString);
			          pptlSATRunTime.pptlsat(PPTLformula_discriptString.substring(0, PPTLformula_discriptString.length()-1));
			          String decision=pptlSATRunTime.check();//
			          System.out.println("decision: "+decision);// 输出判定结果
			          if(decision!=null&&decision.contains("公式可满足")) {
			        	  String path = ConfigPath.change_path("downloadpath")+"\\lnfg.bmp"; 
			      			changePhoto(path);
			      			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The formula can be satisfied.", "System Prompt", JOptionPane.INFORMATION_MESSAGE);
			          }else
			        	 /**
			        	  * lichunyi  更改为相对路径
			        	  * 
			        	  * */
			          {
			        	  String path = System.getProperty("user.dir")+"\\src\\pptlsatfile\\fail.bmp"; 
			        	  changePhoto(path);
			        	  JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The formula can not be satisfied.", "System Prompt", JOptionPane.INFORMATION_MESSAGE);
			          }
					}
					
					else if(e1.getSource() == button[0]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"prj"+formula.substring(c));
					}
					else if(e1.getSource() == button[1]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"<>"+formula.substring(c));
					}
					else if(e1.getSource() == button[2]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"[]"+formula.substring(c));
					}
					else if(e1.getSource() == button[3]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"fin"+formula.substring(c));
					}
					else if(e1.getSource() == button[4]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"()"+formula.substring(c));
					}
					else if(e1.getSource() == button[5]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"->"+formula.substring(c));
					}
					else if(e1.getSource() == button[6]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"&&"+formula.substring(c));
					}
					else if(e1.getSource() == button[7]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"||"+formula.substring(c));
					}
					else if(e1.getSource() == button[8]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+"("+formula.substring(c));
					}
					else if(e1.getSource() == button[9]){  //编辑公式 
						int   c=formulaEditor.getCaretPosition(); 
						String formula=formulaEditor.getText();
						formulaEditor.setText(formula.substring(0,c)+")"+formula.substring(c));
					}
					
//				}
//			});
		}
	}
	
	public String changeFinal(String formula) {
		
//		formula=formula.replace("fin", "empty->");
//		return formula;
		
		if(!formula.contains("fin")) {
			return formula;
		}else
		{
			formula=formula.replace("fin", "empty->");
			return formula;
		}
	}
	
	
	public void changePhoto(String picName) {
		System.out.println("change photo :"+picName);
		
			File file = new File(picName);
			Image image=null;
			try {
				image = ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		bg=image.getScaledInstance(600, 700, Image.SCALE_SMOOTH);;
		/*
		 * JLabel只new一次，保证所有的点击操作使用同一个JLabel，唯一不同的是它的icon
		 * 动态修改图片，通过修正setIcon完成，它会自动刷新背景的
		 */
		if(jLabel==null){
			jLabel = new JLabel(new ImageIcon(bg));
			jLabel.setOpaque(false);
			jLabel.setBounds(0, 0, 800, 1000);
			rightpanel.add(jLabel,BorderLayout.CENTER);

		}else{
			jLabel.setIcon(new ImageIcon(bg));
		}
	}




	class OpenHelperItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						//首先判断是否支持Desktop,如果支持则使用下面的简单代码，否则使用else中的复杂代码
						if(Desktop.isDesktopSupported()){
							Desktop.getDesktop().open(new File("软件使用手册.chm"));
						}
						else{
							//找到项目的根路径
							String contextPath = System.getProperty("user.dir");
							File file=new File(contextPath);
							String p = file.getPath();
							file = new File(p);
							String helpFilePath = p + "\\软件使用手册.chm";
							Runtime.getRuntime().exec("hh.exe "+helpFilePath);
						}
					} catch (Exception e) {
						System.out.println("Error exec!");
					}
				}
			});

		}
	}
	class ImportProjectItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
				}
			});

		}
	}

	public MainPro30 getMainPro() {
		return mainPro;
	}
	public void setMainPro(MainPro30 mainPro) {
		this.mainPro = mainPro;
	}
	public JButton[] getButton() {
		return button;
	}
	public void setButton(JButton[] button) {
		this.button = button;
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JPanel getRightpanel() {
		return rightpanel;
	}
	public void setRightpanel(JPanel rightpanel) {
		this.rightpanel = rightpanel;
	}
	public JScrollPane getRightscroll() {
		return rightscroll;
	}
	public void setRightscroll(JScrollPane rightscroll) {
		this.rightscroll = rightscroll;
	}
	public JPanel getLeftpanel() {
		return leftpanel;
	}
	public void setLeftpanel(JPanel leftpanel) {
		this.leftpanel = leftpanel;
	}
	
	

	


	public static void main(String[] args) {
		

				SwingUtilities.invokeLater(new Runnable(){
		            @Override
					public void run(){
		            	try {
							new MainPro30();
//							mainPro30.initWinForm();
						} catch (Exception e) {
							e.printStackTrace();
						}
		            }
		        });
		
	}
}