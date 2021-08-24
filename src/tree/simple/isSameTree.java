package tree.simple;

/**
 * @Description:相同的树
 * @Author: wenjianli
 * @Date: 2021/8/24 19:43
 */
public class isSameTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        treeNode1.right.left = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(20);
        System.out.println(isSameTree(treeNode1,treeNode2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null || q==null) return false;
        if (p.val != q.val)  return  false;
        Boolean left = isSameTree(p.left,q.left);
        Boolean right = isSameTree(p.right,q.right);
        if (left && right) return true;
        if (!left && !right) return  true;
        return false;
    }
}
