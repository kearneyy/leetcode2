package Morris算法;

//实现中序遍历

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//类似线索二叉树
//时间o(n) 空间o(1)

/**
 * 当前节点cur，一开始cur来到树头，当cur==null停止
 * 1.cur无左树，cur=cur.right
 * 2.cur有左树，找到左树最右节点mostright
 *  1).mostright的右指针指向null的，mostright.right=cur,cur=cur.left;
 *  2).mostright的右指针指向cur，mostright的右指针指向cur，mostright.right=null,cur=cur.right
 */
public class morris_1 {

    public static void morris(TreeNode head) {
        if (head == null)
            return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if(mostRight!=null)
            {
                //找到cur左树真实的最右
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {//mostRight==cur
                    mostRight.right = null;
                    //这里出来后会从if(mostRight!=null)里出来，所以可以不用写continue
                }
            }
            cur=cur.right;
        }
    }
}
