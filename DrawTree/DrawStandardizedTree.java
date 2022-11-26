package DrawTree;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import btree.TreeNode;
import edu.stanford.nlp.trees.Tree;
import stanfordnlp.ChDemo;

public class DrawStandardizedTree extends JFrame{
	 
	 TreeNode node =new TreeNode();
	 TreeNode root =new TreeNode();
	 
	 
	  public DrawStandardizedTree(TreeNode node) {
		this.node = node;
		this.root = node;
	
		console_print_tree(root,1);
		view_tree(root,node,1,10);
	}


	public DrawStandardizedTree() {
		// TODO Auto-generated constructor stub
	}


		/**
	**************************************************************************
	***  可视化逻辑树
	**** lichunyi 12-14
	*/
		/** 
		 * @see node_depth等变量，用于绘制语法树设立。
		 * @param store_node_weigh,store_node_depth 储存数组，一个储存宽度，一个储存深度
		 */  
		public static String natural_language;
		public static int node_depth = 10;
		public static int node_weigh = 100;
		public static int[] store_node_depth = new int[400];
		public static int[] store_node_weigh = new int[400];
		public static String[] store_node_label = new String[400];
		public static int count = 0;
		/** 
		 * *************************************************************************************
		 * @see view_tree，用于二叉树的递归遍历，处理完将位置信息数组和标签数组传入画板中。
		 * get_depth 是treenode类的函数，表示返回节点的层数
		 * 
		 * 该函数，输入树的根节点，树的根节点，常数1常数10（画图用）
		 * 在函数内部实现的为储存二叉树的节点在画板位置信息。
		 */  
	    public static String regex="[-0-9].*";
	  
	  public static void view_tree(TreeNode root, TreeNode node, int layer, int pre_node_depth)
	  {
    	  
  	 /***
     绘画树的调制信息		    	
*/
//				System.out.printf("树的第%d层",node.get_depth(root, node, 0)+layer);    
		      	node_depth=(node.get_depth(root, node, 0)+layer)*60;
				//node_weigh=node_weigh+10;
		      	 if (pre_node_depth > node_depth)
		           {
		           	node_weigh=node_weigh+100;
		           }		        	  
		      	 /***
                 绘画树的调制信息		    	
*/
//		          System.out.println("宽度:"+node_weigh+"深度:"+node_depth+"节点的信息:"+node.svalue.replaceAll(regex, ""));
		          store_node_depth[count]=node_depth;
		          store_node_weigh[count]=node_weigh;
		          store_node_label[count]=node.svalue.replaceAll(regex, "");
		          count++;
		          if(node.left!=null)
		          {
		        	  /***
		                 绘画树的调制信息		    	
		*/
//				          System.out.println("该节点的左孩子为"+node.left.svalue);
		        	  /***
		                 绘画树的调制信息		    	
		*/
//				          System.out.println("该树的根节点为"+root.svalue);
		          	pre_node_depth = node_depth;
		          	view_tree(root,node.left,layer+1, pre_node_depth);
		          }
		          if(node.right!=null)
		          {
		        	  /***
	                  绘画树的调制信息		    	
	*/
//		        	System.out.println("该节点的左孩子为"+node.right.svalue);
		          	pre_node_depth = node_depth;
		          	node_weigh=node_weigh+200;
		          	view_tree(root,node.right,layer+1, pre_node_depth);
		          }
	         	
	 
	  }

	  
		public void console_print_tree(TreeNode node, int layer)
		{
			/***
            绘画树的调制信息		    	
*/
//	          System.out.println("当前遍历的节点为"+node.svalue+"层数为"+layer);
			if (node.left!=null)
			{
				console_print_tree(node.left,layer+1);
			}
			if (node.right!=null)
			{
				console_print_tree(node.right,layer+1);
			}
			
		}

	   public static void main(String[] args) {
			/** 
			 * 
			 *定义储存画板的容器 
			 */   
	    	
	    	ChDemo frame = new ChDemo();
	        frame.setSize(800, 600);  
	        frame.setVisible(true);  
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  	TreePanel drawtree = new TreePanel(store_node_depth,store_node_weigh,store_node_label);
		  	
		    for(int i =0 ; i< 10; i++)
		    {
/***
                  绘画树的调制信息		    	
*/
//		    	System.out.printf("节点的深度：",store_node_depth[i]);
//		    	System.out.printf("节点的宽度：",store_node_weigh[i]);
//		    	System.out.println("节点的标签："+store_node_label[i]);
		    }	
		  	
			frame.add(drawtree);
			frame.setVisible(true);
	   }
}
