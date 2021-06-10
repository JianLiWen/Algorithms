package tree;

import java.util.List;

/**
 * @Description:对称二叉树
 * @Author: wenjianli
 * @Date: 2021/6/10 20:17
 */
/*
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(3);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right.left = new TreeNode(4);
        System.out.println(isSymmetric(treeNode1));

    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public static boolean check(TreeNode p,TreeNode q){
        if (p==null && q == null){
            return  true;
        }
        if (p==null || q==null){
            return false;
        }
        return p.val==q.val && check(p.left,q.right) && check(p.right,q.left);
    }

}
