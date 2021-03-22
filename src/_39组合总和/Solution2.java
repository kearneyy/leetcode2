package _39组合总和;

import java.util.*;

//参考https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
//回溯
class Solution2 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);//排序 为了剪枝

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            path.addLast(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);
            // 状态重置
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3,5}, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}