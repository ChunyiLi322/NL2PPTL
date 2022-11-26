package btree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public int ivalue;//�ڵ���:�������
	public int type;//�ڵ����� 0 ���� 1 ���ӷ�
	public String  svalue;//�ڵ��ǩ:,��������,�����Ӵ�
	public TreeNode left; //��������
	public TreeNode right;
	public int mark;
	public int flag_has_father;
    public  TreeNode(){
    	 this.ivalue=0;
    	 this.type=0;  //0 ���� 1 ���ӷ�
    	 this.svalue=null;
    	 this.left=null;
    	 this.right=null;
    	 this.mark=-1;
    	 this.flag_has_father=-1;
     }
    
    
	/** 
	 * *************************************************************************************
	 * @see ����TreeNode�ķ���
	 * 
	 */  
    
    
	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int depth(TreeNode node){
		if(node==null){
			return 0;
		}else{
			int i=depth(node.getLeft());
			int j=depth(node.getRight());
			return (i<j)?(j+1):(i+1);
		}
	}

	public TreeNode getChild(int i)
	{
		if(i == 0)
		{
		return this.left;
		}else
		{
		return this.right;
		}		
	}
	
	public String label(TreeNode treenode)
	{
		return treenode.svalue;
	}
	
	public List<TreeNode> children()
	{
		List<TreeNode> treenode_list = new ArrayList<TreeNode>();
		treenode_list.add(this.left);
		treenode_list.add(this.right);
		return treenode_list;
	}


	
	/**
	 
	 �ú�������ýڵ����ڲ���
	 @param root_divΪ���ĸ��ڵ�
	  @param find_nodeΪ��Ҫ���ҵĽڵ�
	   @param find_depthΪ�ýڵ�Ĳ���
	 
	*/
	public int get_depth(TreeNode root_div, TreeNode find_node ,int find_depth){
		//System.out.println("��ǰ���ҵĵĽڵ�Ϊ"+find_node.svalue+"��ǰ�Ĳ���Ϊ"+find_depth);
		if(root_div!=find_node)
		{
		if(root_div.getLeft()!=null)
		{
		get_depth(root_div.left, find_node, find_depth+1);
		}
		if(root_div.getRight()!=null)
		{
		get_depth(root_div.right, find_node,find_depth+1);	
		}
		}
		return find_depth;
	}

	

    
}
