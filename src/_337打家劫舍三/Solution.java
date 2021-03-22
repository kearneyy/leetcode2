package _337打家劫舍三;

/**
 * 337. 打家劫舍 III
 * 难度
 * 中等
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

//自己写的垃圾递归不通过,错误写法，只考虑隔层，而不是最大值
class Solution {
    static int total1=0;
    static int total2=0;

    public static int rob(TreeNode root) {
        jumpAdd1(root);
        if (root.right!=null)
        jumpAdd2(root.right);
        if(root.left!=null)
        jumpAdd2(root.left);
        return Math.max(total1, total2);
    }

    public static void jumpAdd1(TreeNode node)
    {
        total1+=node.val;
        if(node.left!=null)
        {
            if(node.left.left!=null)
            {
                jumpAdd1(node.left.left);
            }
            if(node.left.right!=null)
            {
                jumpAdd1(node.left.right);
            }
        }
        if(node.right!=null)
        {
            if(node.right.left!=null)
            {
                jumpAdd1(node.right.left);
            }
            if(node.right.right!=null)
            {
                jumpAdd1(node.right.right);
            }
        }
    }

    public static void jumpAdd2(TreeNode node)
    {
        total2+=node.val;
        if(node.left!=null)
        {
            if(node.left.left!=null)
            {
                jumpAdd2(node.left.left);
            }
            if(node.left.right!=null)
            {
                jumpAdd2(node.left.right);
            }
        }
        if(node.right!=null)
        {
            if(node.right.left!=null)
            {
                jumpAdd2(node.right.left);
            }
            if(node.right.right!=null)
            {
                jumpAdd2(node.right.right);
            }
        }
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        System.out.println(rob(node1));
    }
}
