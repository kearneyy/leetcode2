package _18四数之和;

import java.util.*;

/**
 * 18. 四数之和
 * 难度
 * 中等
 * 反馈
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
    class Solution {
        static Set<List<Integer>> sets =new HashSet<>();
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Deque deque = new ArrayDeque();
            dfs(nums,target,0,deque);
            return new ArrayList<>(sets);
        }

        private static void dfs(int[] nums,int target,int index,Deque deque){
            if(deque.size()==4)
            {
                if(target==0)
                {
                    sets.add(new ArrayList<>(deque));
                }
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if(nums[i]>0&&target-nums[i]<0)
                    return;
                deque.add(nums[i]);
                dfs(nums,target-nums[i],i+1,deque);
                deque.removeLast();
            }

        }


    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{1, -2, -5, -4, -3,3,3,5}, -11);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}