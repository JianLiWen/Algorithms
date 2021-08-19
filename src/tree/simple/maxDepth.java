package tree.simple;

/**
 * @Description:二叉树的最大深度
 * @Author: wenjianli
 * @Date: 2021/8/19 18:16
 */
/*
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
 返回它的最大深度 3 。
 */
public class maxDepth {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        System.out.println(maxDepth(treeNode1));
    }
    public static int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

}
