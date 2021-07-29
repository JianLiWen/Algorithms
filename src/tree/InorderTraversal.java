package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:二叉树的中序遍历
 * @Author: wenjianli
 * @Date: 2021/6/1 20:45
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(8);
        treeNode1.left.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(10);
        List<Integer> list = inorderTraversal(treeNode1);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }

    // 基本算法
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list;
    }

    public static void inOrder(TreeNode root,List<Integer> res){
        if (root==null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
