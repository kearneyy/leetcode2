package _46全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 难度
 * 中等
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length==0)
            return lists;
        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(lists,nums,used,path);
        return lists;
    }

    private static void dfs(List<List<Integer>> lists,int[] nums,boolean[] used,List<Integer> path)
    {
        if(path.size()==nums.length)
        {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i]=true;
                path.add(nums[i]);
                dfs(lists, nums, used, path);
                path.remove(path.size() - 1);
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1,2,3,4,5});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}