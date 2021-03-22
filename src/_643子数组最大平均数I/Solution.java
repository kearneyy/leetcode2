package _643子数组最大平均数I;

import java.util.ArrayDeque;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


//不用每次都算平均数 直接算最大sum
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        double maxsum = sum;
        for (int i = k; i < nums.length; i++) {
           sum=sum-nums[i-k]+nums[i];
           maxsum = Math.max(maxsum,sum);
        }
        return maxsum/k;
    }
}