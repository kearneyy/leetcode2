package _40组合总合II;

import java.util.*;

class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists  =new ArrayList<>();
        if(candidates.length==0)
            return lists;
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,lists,deque);
        return lists;
    }

    private static void dfs(int[] candidates,int target,int begin,List<List<Integer>> lists,Deque<Integer> deque)
    {
        if(target==0)
        {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(target-candidates[i]<0)
            {
                break;
            }
            if(i>begin&&candidates[i]==candidates[begin])
                continue;
            deque.add(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,lists,deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{10,1,2,7,6,1,5,1},8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}