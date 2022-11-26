package btree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public int ivalue;//节点编号:标记命题
	public int type;//节点类型 0 句子 1 连接符
	public String  svalue;//节点标签:,命题内容,或连接词
	public TreeNode left; //左右子树
	public TreeNode right;
	public int mark;
	public int flag_has_father;
    public  TreeNode(){
    	 this.ivalue=0;
    	 this.type=0;  //0 句子 1 连接符
    	 this.svalue=null;
    	 this.left=null;
    	 this.right=null;
    	 this.mark=-1;
    	 this.flag_has_father=-1;
     }
    
    
	/** 
	 * *************************************************************************************
	 * @see 扩充TreeNode的方法
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
	 
	 该函数输出该节点所在层数
	 @param root_div为树的根节点
	  @param find_node为需要查找的节点
	   @param find_depth为该节点的层数
	 
	*/
	public int get_depth(TreeNode root_div, TreeNode find_node ,int find_depth){
		//System.out.println("当前查找的的节点为"+find_node.svalue+"当前的层数为"+find_depth);
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
