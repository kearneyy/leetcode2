package _337打家劫舍三;

//递归解法，将累加值写在返回值里
public class Solution2 {
    public static int rob(TreeNode root) {
        if(root ==null)
            return 0;
        int money = root.val;
        if(root.left!=null)
            money+=(rob(root.left.left)+rob(root.left.right));
        if(root.right!=null)
            money+=(rob(root.right.left)+rob(root.right.right));
        return Math.max(money,rob(root.right)+rob(root.left));
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node7;
        node3.right=node6;
        System.out.println(rob(node1));
    }
}
