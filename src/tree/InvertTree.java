package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:翻转二叉树
 * @Author: wenjianli
 * @Date: 2021/6/11 17:27
 */
/*
翻转一棵二叉树。
输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class InvertTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(7);
        treeNode1.left.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(3);
        treeNode1.right.left = new TreeNode(6);
        treeNode1.right.right = new TreeNode(9);

        TreeNode node = inOrderResverse(treeNode1);
        System.out.print(node.left.val);
        System.out.print(node.left.left.val);
        System.out.print(node.left.right.val);
        System.out.print(node.right.val);
        System.out.print(node.right.left.val);
        System.out.print(node.right.right.val);
    }

    // mine -一次通过，0ms
    public static TreeNode transform(TreeNode root){
        TreeNode p = root;
        TreeNode a = root.left;
        TreeNode b = root.right;
        p.left = b;
        p.right = a;
        return p;
    }

    public static TreeNode inOrderResverse(TreeNode root){
        if (root==null){
            return null;
        }
        transform(root);
        inOrderResverse(root.left);
        inOrderResverse(root.right);
        return root;
    }
}
