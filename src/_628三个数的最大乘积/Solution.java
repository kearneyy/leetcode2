package _628三个数的最大乘积;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 *
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n =nums.length;
        int num1 = nums[0]*nums[1]*nums[2];
        int num2 = nums[n-1]*nums[n-2]*nums[n-3];
        int num3 = nums[0]*nums[1]*nums[n-1];
        return Math.max(num1,Math.max(num2,num3));
    }
}
