package _501二叉树中的众数;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * 难度
 * 简单
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 * 提示：如果众数超过1个，不需考虑输出顺序
 */

class TreeNode {
    int val;
   TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    static Map<Integer,Integer> map = new HashMap<>();
    static int max=1;
    public static int[] findMode(TreeNode root) {
        if(root==null)
            return new int[]{};
        dfs(root);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()==max)
                list.add(entry.getKey());
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=list.get(i);
        }
        return nums;
    }

    public static void dfs(TreeNode node){
        if(node==null)
            return;
        dfs(node.left);
        int val = node.val;
        if(map.containsKey(val))
        {
            Integer integer = map.get(val);
            integer++;
            if(integer>max)
                max=integer;
            map.put(val,integer);
        }
        else
        {
            map.put(val,1);
        }
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.right=node2;
        node2.left=node3;
        int[] mode = findMode(node1);
        for (int i : mode) {
            System.out.println(i);
        }
    }
}