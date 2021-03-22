package Morris算法;

//中序遍历
public class morris_in {
    public static void morrisIn(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode cur = node;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }


    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(2);
        TreeNode node14 = new TreeNode(5);
        node11.left = node12;
        node12.left = node14;
        node11.right = node13;
        morrisIn(node11);
    }
}
