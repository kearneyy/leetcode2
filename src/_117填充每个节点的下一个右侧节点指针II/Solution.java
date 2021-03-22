package _117填充每个节点的下一个右侧节点指针II;

import java.util.*;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 难度
 * 中等
 * 给定一个二叉树
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */



class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

/**
 * 自己写的，有点sb，把每一层的放到一个list里然后连接，这题用层次遍历好一些
 */
class Solution {
    public static Node connect(Node root) {
        if(root==null)
            return null;
        Map<Integer, List<Node>> map = new HashMap<>();
        dfs(root,map,0);
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            List<Node> nodes = map.get(integer);
            for (int i = 0; i < nodes.size(); i++) {
                if(i!=nodes.size()-1)
                {
                    nodes.get(i).next=nodes.get(i+1);
                }
                else
                {
                    nodes.get(i).next=null;
                }
            }
        }
        return root;
    }

    private static void dfs(Node root, Map<Integer, List<Node>> map, int depth)
    {
        if(root==null)
            return;
        depth++;
        if(map.containsKey(depth))
        {
            List<Node> nodes = map.get(depth);
            nodes.add(root);
        }
        else
        {
            List<Node> lists = new ArrayList<>();
            lists.add(root);
            map.put(depth,lists);
        }
        dfs(root.left,map,depth);
        dfs(root.right,map,depth);
    }
}