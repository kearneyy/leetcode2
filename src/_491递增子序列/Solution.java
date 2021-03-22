package _491递增子序列;

import java.util.ArrayList;
import java.util.List;

/**
 * 491. 递增子序列
 * 难度
 * 中等
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * 示例:
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */

/**
 * List<List<Integer>> ans = new ArrayList<List<Integer>>();
 * List<Integer> temp = new ArrayList<Integer>();
 * public void dfs(int cur, int[] nums) {
 *     if (cur == nums.length) {
 *         // 判断是否合法，如果合法判断是否重复，将满足条件的加入答案
 *         if (isValid() && notVisited()) {
 *             ans.add(new ArrayList<Integer>(temp));
 *         }
 *         return;
 *     }
 *     // 如果选择当前元素
 *     temp.add(nums[cur]);
 *     dfs(cur + 1, nums);
 *     temp.remove(temp.size() - 1);
 *     // 如果不选择当前元素
 *     dfs(cur + 1, nums);
 * }
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences/solution/di-zeng-zi-xu-lie-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    static List<Integer> temp = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public static void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        //这下面的是不选择情况，如果小于是一定会执行的，但是如果有相同数的也不选择直接跳过，相当于选择后者不选择前者，或者可改为用hashset来去重
        if (nums[cur]!= last) {
            dfs(cur + 1, last, nums);
        }
    }


}
