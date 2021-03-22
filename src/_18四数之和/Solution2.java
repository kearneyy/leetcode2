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

/**
 * 如果剩余可选的数字数量少于 n，则剪掉（递归返回）；
 * 每层递归中，从第二轮循环开始，如果数组中当前数字和前一个相同，则剪掉（进行下一次循环，这条的任务就是去重）；
 * 如果 当前数字 + 已确定数字的和 + (n - 1) * 排序后数组中当前数字的下一个数字 > target，则说明后面的数无论怎么选，加起来都一定大于 target，所以剪掉（递归返回）；
 * 如果 当前数字 + 已确定数字的和 + (n - 1) * 排序后数组最后一个数字 < target，则说明后面的数无论怎么选，加起来都一定小于 target，所以剪掉（进行下一次循环）；
 *
 * 作者：Provencih
 * 链接：https://leetcode-cn.com/problems/4sum/solution/mei-kan-dao-ji-ge-hui-su-de-ti-jie-na-wo-lai-xie-y/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
    class Solution2 {
        static List<List<Integer>> lists = new ArrayList<>();
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Deque deque = new ArrayDeque();
            dfs(nums,target,0,deque,0);
            return lists;
        }

        private static void dfs(int[] nums,int target,int index,Deque deque,int total){
            if(deque.size()==4)
            {
                if(target==total)
                {
                    lists.add(new ArrayList<>(deque));
                }
                return;
            }
            for (int i = index; i < nums.length; i++) {
                if (nums.length- i < 4 - deque.size()) //剪枝
                return;
                if (i > index && nums[i] == nums[i - 1]) //去重
                    continue;
                if (i < nums.length - 1 && total + nums[i] +(3 - deque.size()) * nums[i + 1] > target) //剪枝
                return;
                if (i < nums.length - 1 && total + nums[i] +(3 - deque.size()) * nums[nums.length - 1] < target) //剪枝
                continue;
                deque.add(nums[i]);
                dfs(nums,target,i+1,deque,total+nums[i]);
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