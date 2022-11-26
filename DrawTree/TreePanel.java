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
 * TODO ���ӻ��﷨���� 
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
	 * @param  tree && store_node_depth �����ڱ���Demo��������store_node_depth�����ݣ���ֹ������Ⱦ��200Ϊ����Ҷ�ӵ����������
	 * �����ռ�ø����ڴ档200������ tree.leaves.size()��̬��ֵ��
	 * @param  store_node_label���������ڵ�����Ϣ��
	 * 
	 */  
	public static int[] store_node_depth = new int[400];
	public static int[] store_node_weigh = new int[400];
	public static String[] store_node_label = new String[400];

	
    /** 
     * �Զ��幹�캯����������¹���Ҫ�ӣ�������������캯��������ڵ�λ����Ϣ�ͽڵ��ǩ��Ϣ�� 
    */  

    public TreePanel(Tree tree_Demo, int[] store_node_depth_Demo, int[] store_node_weigh_Demo, String[] store_node_label_Demo){	
        tree = tree_Demo;
        store_node_depth = store_node_depth_Demo;
        store_node_weigh = store_node_weigh_Demo;
        store_node_label = 	store_node_label_Demo;		        	  
     	 /***
        �滭���ĵ�����Ϣ		    	
*/
//      System.out.println("TreePanel,����"+tree);
    }  
      
    
    public TreePanel( int[] store_node_depth_Demo, int[] store_node_weigh_Demo, String[] store_node_label_Demo){	
        store_node_depth = store_node_depth_Demo;
        store_node_weigh = store_node_weigh_Demo;
        store_node_label = 	store_node_label_Demo;     	 
        /***
        �滭���ĵ�����Ϣ		    	
*/
//      System.out.println("TreePanel,����"+tree);
    }  
    /** 
     * ����Ҫ����ʱ��Ķ������ 
     * @param g ���� 
     * @see g2.setColor ���û�ͼ����ɫ
     * @see store_node_depth[i]>0 ��ʾ�����λ����Ϣ������ֵ
     * @see g2.drawOval�Ե�ǰλ��Ϊ���Ļ�Բ
     * @see g2.drawString�Ե�ǰλ����д�ڵ��ǩ
     * @see store_node_weigh[i]>store_node_weigh[i-1] ��ȱ���ʱ���ߵ���������ұ�һ������
     * @see for (int j = i-1 ; j>0 ;j--) ��ʾ�ߵ���������ұ�һ��������һ���ڵ㣬ȥ��ǰ����Ѱ���丸�ڵ�
     * @see store_node_depth[i] == store_node_depth[j] && store_node_depth[j-1]<store_node_depth[i] ��������ұ�һ��������һ���ڵ��丸�ڵ����������������
     * ��1����߶ȱ���ȵ�ǰ�ڵ�ߣ�2������������  �������������������һ���ڵ�
     * @see store_node_depth[i]>store_node_depth[i-1] �ڵ�ǰ��������¼���������һ���ڵ�ĸ߶�С���丸�ڵ�ĸ߶ȣ������������λ��һ�¡�
     * @see g2.drawLine ���Ӹ��ӽڵ�
     */  

      
    public void paint(Graphics g){
    	super.paint(g);	
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		for(int i = 0; i<400;i++)

				if(store_node_depth[i]>0)
				{
					//System.out.println("���"+store_node_weigh[i]+"���"+store_node_depth[i]);
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
            
      
        
  