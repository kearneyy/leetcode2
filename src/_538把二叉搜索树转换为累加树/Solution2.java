package _538把二叉搜索树转换为累加树;


//因为二叉搜索树中序遍历是递增的 所以只需要倒着中序遍历一遍就可以
class Solution2 {
    static int num=0;

    public static TreeNode convertBST(TreeNode root) {
        if (root==null)
        return root;
        BST(root);
       return root;
    }

    public static void BST(TreeNode root)
    {
        if(root.right!=null)
        BST(root.right);
        int val = root.val;
        root.val+=num;
        num+=val;
        if(root.left!=null)
        BST(root.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left=node2;
        node1.right=node3;
        convertBST(node1);
        System.out.println(node1);
    }
}