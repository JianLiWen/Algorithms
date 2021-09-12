package tree.simple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description:二叉树的最小深度
 * @Author: wenjianli
 * @Date: 2021/9/6 20:39
 */
public class minDepth {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.left.right = new TreeNode(2);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        System.out.println(minDepth(treeNode1));
    }
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //使用队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 初始root节点为一层初始化
        int depth = 1;
        // 循环遍历队列，即每次加入的新节点
        while (!q.isEmpty()){
            // 一个for循环代表一层
            int s = q.size();
            for (int i=0;i<s;i++){
                TreeNode node = q.poll();
                if (node.left==null && node.right==null){
                    return depth;
                }
                if (node.left!=null){
                    q.offer(node.left);
                }
                if (node.right!=null){
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
