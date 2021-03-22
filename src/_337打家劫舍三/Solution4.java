package _337打家劫舍三;

//动态规划,类似后序遍历 左右根

/**
 * 上面两种解法用到了孙子节点，计算爷爷节点能偷的钱还要同时去计算孙子节点投的钱，虽然有了记忆化，但是还是有性能损耗。
 * 我们换一种办法来定义此问题
 * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
 *
 * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
 * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
 *
 * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
 * 任何一个节点能偷到的最大钱的状态可以定义为
 *
 * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
 * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
 *表示为公式如下
 * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
 * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
 * 作者：reals
 * 链接：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution4 {
    public static int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public static int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
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
