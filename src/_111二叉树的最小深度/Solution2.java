package _111二叉树的最小深度;


/**
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 39.8 MB
 * , 在所有 Java 提交中击败了
 * 61.22%
 * 的用户
 * 自己写的
 */
class Solution2 {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        find(root, 0);
        return min;
    }

    public void find(TreeNode root, int depth) {
        depth++;
        if (root.left == null && root.right == null) {
            if (depth < min)
                min = depth;
        }
        if (depth > min) {
            return;
        }
        if (root.left != null)
            find(root.left, depth);
        if (root.right != null)
            find(root.right, depth);
    }
}