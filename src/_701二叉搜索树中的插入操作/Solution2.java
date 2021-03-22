package _701二叉搜索树中的插入操作;

//简便写法
class Solution2 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val) root.left = insertIntoBST(root.left, val);
        if(root.val < val) root.right = insertIntoBST(root.right, val);
        return root;

    }
}