package _501二叉树中的众数;

import java.util.ArrayList;

//没必要用map
//用一个值来记录最大值，用list来记录数据，如果curtime变得更大，就把list清空
class Solution2 {
    int preVal = 0, curTimes = 0, maxTimes = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        //list转换为int[]
        int size = list.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    //二叉搜索树中序遍历是递增顺序
    public void traversal(TreeNode root){
        if(root != null){
            traversal(root.left);
            //判断当前值与上一个值的关系, 更新 curTimes 和 preVal
            if(preVal == root.val){
                curTimes++;
            }else{
                preVal = root.val;
                curTimes = 1;
            }
            //判断当前数量与最大数量的关系, 更新 list 和 maxTimes
            if(curTimes == maxTimes){
                list.add(root.val);
            }else if(curTimes > maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
    }
}