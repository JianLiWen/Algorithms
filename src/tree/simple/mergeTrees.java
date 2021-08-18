package tree.simple;

/**
 * @Description:合并二叉树
 * @Author: wenjianli
 * @Date: 2021/7/30 11:54
 */
/*
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
输入:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
输出:
合并后的树:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
	 注意: 合并必须从两个树的根节点开始。
 */

public class mergeTrees {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(3);
        treeNode1.left.left = new TreeNode(5);
        treeNode1.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(1);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.right = new TreeNode(3);
        treeNode2.right.right = new TreeNode(7);
        TreeNode mergeNode = mergeTrees(treeNode1,treeNode2);
        System.out.println(mergeNode.val);
        System.out.println(mergeNode.left.val);
//        System.out.println(mergeNode.left.left.val);
        System.out.println(mergeNode.left.right.val);
        System.out.println(mergeNode.right.val);
        System.out.println(mergeNode.right.right.val);

    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        TreeNode mergeNode = new TreeNode(root1.val + root2.val);
        mergeNode.left = mergeTrees(root1.left,root2.left);
        mergeNode.right = mergeTrees(root1.right,root2.right);
        return mergeNode;
    }
}
