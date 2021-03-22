package _501二叉树中的众数;

import java.util.ArrayList;

//mirros统计
class Solution3 {
    static int base,count,maxCount;
    static ArrayList<Integer> answer = new ArrayList<Integer>();
    static public int[] findMode(TreeNode root) {
        //list转换为int[]
        if(root==null)
            return new int[]{};
        TreeNode cur  = root;
        TreeNode mostRight = null;
        while (cur!=null)
        {
            mostRight=cur.left;
            if(mostRight!=null)
            {
                while (mostRight.right!=null&&mostRight.right!=cur)
                {
                    mostRight=mostRight.right;
                }
                if(mostRight.right==null)
                {
                    mostRight.right=cur;
                    cur=cur.left;
                    continue;
                }
                else
                {
                    mostRight.right=null;
                }
            }
            update(cur.val);
            cur=cur.right;
        }
        int size = answer.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }

    public static void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
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