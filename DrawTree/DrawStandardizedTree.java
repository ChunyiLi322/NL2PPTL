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
	***  ���ӻ��߼���
	**** lichunyi 12-14
	*/
		/** 
		 * @see node_depth�ȱ��������ڻ����﷨��������
		 * @param store_node_weigh,store_node_depth �������飬һ�������ȣ�һ���������
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
		 * @see view_tree�����ڶ������ĵݹ�����������꽫λ����Ϣ����ͱ�ǩ���鴫�뻭���С�
		 * get_depth ��treenode��ĺ�������ʾ���ؽڵ�Ĳ���
		 * 
		 * �ú������������ĸ��ڵ㣬���ĸ��ڵ㣬����1����10����ͼ�ã�
		 * �ں����ڲ�ʵ�ֵ�Ϊ����������Ľڵ��ڻ���λ����Ϣ��
		 */  
	    public static String regex="[-0-9].*";
	  
	  public static void view_tree(TreeNode root, TreeNode node, int layer, int pre_node_depth)
	  {
    	  
  	 /***
     �滭���ĵ�����Ϣ		    	
*/
//				System.out.printf("���ĵ�%d��",node.get_depth(root, node, 0)+layer);    
		      	node_depth=(node.get_depth(root, node, 0)+layer)*60;
				//node_weigh=node_weigh+10;
		      	 if (pre_node_depth > node_depth)
		           {
		           	node_weigh=node_weigh+100;
		           }		        	  
		      	 /***
                 �滭���ĵ�����Ϣ		    	
*/
//		          System.out.println("���:"+node_weigh+"���:"+node_depth+"�ڵ����Ϣ:"+node.svalue.replaceAll(regex, ""));
		          store_node_depth[count]=node_depth;
		          store_node_weigh[count]=node_weigh;
		          store_node_label[count]=node.svalue.replaceAll(regex, "");
		          count++;
		          if(node.left!=null)
		          {
		        	  /***
		                 �滭���ĵ�����Ϣ		    	
		*/
//				          System.out.println("�ýڵ������Ϊ"+node.left.svalue);
		        	  /***
		                 �滭���ĵ�����Ϣ		    	
		*/
//				          System.out.println("�����ĸ��ڵ�Ϊ"+root.svalue);
		          	pre_node_depth = node_depth;
		          	view_tree(root,node.left,layer+1, pre_node_depth);
		          }
		          if(node.right!=null)
		          {
		        	  /***
	                  �滭���ĵ�����Ϣ		    	
	*/
//		        	System.out.println("�ýڵ������Ϊ"+node.right.svalue);
		          	pre_node_depth = node_depth;
		          	node_weigh=node_weigh+200;
		          	view_tree(root,node.right,layer+1, pre_node_depth);
		          }
	         	
	 
	  }

	  
		public void console_print_tree(TreeNode node, int layer)
		{
			/***
            �滭���ĵ�����Ϣ		    	
*/
//	          System.out.println("��ǰ�����Ľڵ�Ϊ"+node.svalue+"����Ϊ"+layer);
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
			 *���崢�滭������� 
			 */   
	    	
	    	ChDemo frame = new ChDemo();
	        frame.setSize(800, 600);  
	        frame.setVisible(true);  
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  	TreePanel drawtree = new TreePanel(store_node_depth,store_node_weigh,store_node_label);
		  	
		    for(int i =0 ; i< 10; i++)
		    {
/***
                  �滭���ĵ�����Ϣ		    	
*/
//		    	System.out.printf("�ڵ����ȣ�",store_node_depth[i]);
//		    	System.out.printf("�ڵ�Ŀ�ȣ�",store_node_weigh[i]);
//		    	System.out.println("�ڵ�ı�ǩ��"+store_node_label[i]);
		    }	
		  	
			frame.add(drawtree);
			frame.setVisible(true);
	   }
}
