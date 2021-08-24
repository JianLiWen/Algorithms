package tree.mideum;


/**
 * @Description:二叉树的最近公共祖先
 * @Author: wenjianli
 * @Date: 2021/8/23 14:18
 */
/*
输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */
public class lowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(5);
        treeNode1.left.left = new TreeNode(6);
        treeNode1.right = new TreeNode(1);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode result = lowestCommonAncestor(treeNode1,p,q);
        System.out.println(result.val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root ==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
