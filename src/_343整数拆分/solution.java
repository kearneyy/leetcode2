package _343整数拆分;

/**
 * 343. 整数拆分
 * 难度
 * 中等
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */

//动态规划，一个数拆成两个数之和，然后用curnum保存，遍历n从1到n-1比较，如果不可拆数字的乘积是j*(i-j)，可拆的话是j*dp[i-j]
class Solution {
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <=n; i++) {
            int curnum = 0;
            for (int j = 1; j < i; j++) {
                curnum = Math.max(curnum,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=curnum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}