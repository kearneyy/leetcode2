package _538把二叉搜索树转换为累加树;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

//自己写的最辣鸡方法，不需要这样写
class Solution {
    static List<Integer> list = new ArrayList<>();

    public static TreeNode convertBST(TreeNode root) {
        findNum(root);
        Collections.sort(list);
        addNum(root);
        return root;
    }

    public static void findNum(TreeNode node)
    {
        if(node==null)
            return;
        list.add(node.val);
        findNum(node.left);
        findNum(node.right);
    }

    public static void addNum(TreeNode node)
    {
        if(node==null)
            return;
        int val = node.val;
        int index = list.indexOf(node.val);
        for (int i = list.size()-1; i >index ;i--) {
            int num = list.get(i);
            if(num<=val)
            break;
            node.val+=num;
        }
        addNum(node.left);
        addNum(node.right);
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
