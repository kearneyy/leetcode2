package _560和为K的子数组;

/**
 * 560. 和为K的子数组
 * 难度
 * 中等
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 暴力法
 */
public class Solution1 {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {

                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        Solution1 solution = new Solution1();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}
