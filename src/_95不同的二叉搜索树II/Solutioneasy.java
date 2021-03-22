package _95不同的二叉搜索树II;

//构建一颗二叉搜索树
public class Solutioneasy {
    public TreeNode createBinaryTree(int n)
    {
        return helper(1,n);
    }

    public TreeNode helper(int start,int end)
    {
        int val = (start+end)/2;
        if(start>end)
        {
            return null;
        }
        TreeNode left = helper(start,val-1);
        TreeNode right = helper(val+1,end);
        TreeNode tree = new TreeNode(val);
        tree.left=left;
        tree.right=right;
        return tree;
    }
}
