package Morris算法;

//后序遍历
public class morris_pos {
    public static void morrisPos(TreeNode node) {
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
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(node);
    }

    public static void printEdge(TreeNode head)
    {
        TreeNode tail = reverseEdge(head);
        TreeNode cur = tail;
        while(cur!=null)
        {
            System.out.println(cur.val+" ");
            cur=cur.right;
        }
        reverseEdge(tail);
    }

    public static TreeNode reverseEdge(TreeNode from)
    {
        TreeNode pre = null;
        TreeNode next = null;
        while (from!=null)
        {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(2);
        TreeNode node14 = new TreeNode(5);
        node11.left = node12;
        node12.left = node14;
        node11.right = node13;
        morrisPos(node11);
    }
}
