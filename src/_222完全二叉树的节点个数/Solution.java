package _222完全二叉树的节点个数;

import java.util.TreeSet;

class TreeNode {
    int val;
   TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

/**
 * 222. 完全二叉树的节点个数
 * 难度
 * 中等
 * 反馈
 * 给出一个完全二叉树，求出该树的节点个数。
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 示例:
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
 * left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点 +root 节点，总数为 2^right。再对左子树进行递归查找。
 *
 * 作者：xiao-ping-zi-5
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/
class Solution {
    public static int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int left = countdeep(root.left);
        int right = countdeep(root.right);
        if(left==right)
        {
            return (1<<left)+countNodes(root.right);
        }
        else
        {
            return (1<<right)+countNodes(root.left);
        }
    }

    public static int countdeep(TreeNode root)
    {
        int deep=0;
        while (root!=null)
        {
            deep++;
            root=root.left;
        }
        return deep;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left=n2;
        n1.right=n3;
        n3.left=n6;
        n2.left=n4;
        n2.right=n5;
        int i = countNodes(n1);
        System.out.println(i);
    }
}