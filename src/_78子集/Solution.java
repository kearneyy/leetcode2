package _78子集;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 难度
 * 中等
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
class Solution {
    static List<List<Integer>> lists = new ArrayList<>();
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        lists.add(list);
        return lists;
    }

    private static void dfs(int index,int[] nums){
        if(index>=nums.length)
        {
            return;
        }
        deque.add(nums[index]);
        lists.add(new ArrayList<>(deque));
        dfs(index+1,nums);
        deque.pollLast();
        dfs(index+1,nums);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = subsets(new int[]{});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}