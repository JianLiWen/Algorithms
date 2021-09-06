package tree.simple;

/**
 * @Description:相同的树
 * @Author: wenjianli
 * @Date: 2021/8/24 19:43
 */
public class isSameTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.right = new TreeNode(2);
        System.out.println(isSameTree(treeNode1,treeNode2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q==null) {
            return true;
        }else if (p==null || q==null) {
            return  false;
        }else if (p.val != q.val) {
            return  false;
        }
        Boolean left = isSameTree(p.left,q.left);
        Boolean right = isSameTree(p.right,q.right);
        return left && right;
    }
}
