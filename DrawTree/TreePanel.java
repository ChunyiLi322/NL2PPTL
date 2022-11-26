package DrawTree;
import java.util.ArrayList;  
import java.util.List;  
import java.awt.Color;  
import java.awt.Font;  
import java.awt.FontMetrics;  
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;  
  
import javax.swing.JPanel;

import edu.stanford.nlp.trees.Tree;  
  
/** 
 * TODO 可视化语法树； 
 * @author Chunyi Li 
 * 
 */  
public class TreePanel extends JPanel {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 5682671188183417429L;
	private static Tree tree;              
	public static int node_depth;
	public static int node_weigh;
	/** 
	 * @param  tree && store_node_depth 等用于保存Demo传过来的store_node_depth等数据，防止数据污染。200为树的叶子的最大数量。
	 * 如果想占用更少内存。200可以用 tree.leaves.size()动态赋值。
	 * @param  store_node_label，保存树节点标记信息。
	 * 
	 */  
	public static int[] store_node_depth = new int[400];
	public static int[] store_node_weigh = new int[400];
	public static String[] store_node_label = new String[400];

	
    /** 
     * 自定义构造函数，如果有新功能要加，再添加其他构造函数，传入节点位置信息和节点标签信息。 
    */  

    public TreePanel(Tree tree_Demo, int[] store_node_depth_Demo, int[] store_node_weigh_Demo, String[] store_node_label_Demo){	
        tree = tree_Demo;
        store_node_depth = store_node_depth_Demo;
        store_node_weigh = store_node_weigh_Demo;
        store_node_label = 	store_node_label_Demo;		        	  
     	 /***
        绘画树的调制信息		    	
*/
//      System.out.println("TreePanel,构造"+tree);
    }  
      
    
    public TreePanel( int[] store_node_depth_Demo, int[] store_node_weigh_Demo, String[] store_node_label_Demo){	
        store_node_depth = store_node_depth_Demo;
        store_node_weigh = store_node_weigh_Demo;
        store_node_label = 	store_node_label_Demo;     	 
        /***
        绘画树的调制信息		    	
*/
//      System.out.println("TreePanel,构造"+tree);
    }  
    /** 
     * 设置要绘制时候的对齐策略 
     * @param g 画笔 
     * @see g2.setColor 设置画图的颜色
     * @see store_node_depth[i]>0 表示储存的位置信息必须有值
     * @see g2.drawOval以当前位置为中心画圆
     * @see g2.drawString以当前位置书写节点标签
     * @see store_node_weigh[i]>store_node_weigh[i-1] 深度遍历时，走到多叉树的右边一个子树
     * @see for (int j = i-1 ; j>0 ;j--) 表示走到多叉树的右边一个子树第一个节点，去向前依次寻找其父节点
     * @see store_node_depth[i] == store_node_depth[j] && store_node_depth[j-1]<store_node_depth[i] 多叉树的右边一个子树第一个节点其父节点必须满足两个条件
     * （1）其高度必须比当前节点高（2）更靠近容器  满足这两个条件最近的一个节点
     * @see store_node_depth[i]>store_node_depth[i-1] 在当前多叉树往下继续遍历的一个节点的高度小于其父节点的高度，与容器最左边位置一致。
     * @see g2.drawLine 连接父子节点
     */  

      
    public void paint(Graphics g){
    	super.paint(g);	
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		for(int i = 0; i<400;i++)

				if(store_node_depth[i]>0)
				{
					//System.out.println("宽度"+store_node_weigh[i]+"深度"+store_node_depth[i]);
					g2.drawOval( store_node_weigh[i], store_node_depth[i], 5, 5);
					g2.drawString(store_node_label[i], store_node_weigh[i], store_node_depth[i]);
					if (i >0 && store_node_weigh[i]>store_node_weigh[i-1])
					{
						for (int j = i-1 ; j>0 ;j--)
						{
							if(store_node_depth[i] == store_node_depth[j])
							{
								if(j>0 && store_node_depth[j-1]<store_node_depth[i])
								{
								g2.drawLine(store_node_weigh[i], store_node_depth[i], store_node_weigh[j-1], store_node_depth[j-1]);
								j=0;
								}

							}
						}
						
						
					}
					if (i >0 && store_node_depth[i]>store_node_depth[i-1])
					{
						g2.drawLine(store_node_weigh[i], store_node_depth[i], store_node_weigh[i], store_node_depth[i]-50);
					}
					
				}
			}
    
   
 }
            
      
        
  