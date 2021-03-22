package _416分割等和子集;

/**
 * 416. 分割等和子集
 * 	每个数组中的元素不会超过 100
 * 	数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if(sum%2!=0)
            return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
        dp[0][0]=true;
        if(nums[0]<=target)//初始化第一行
        {
            dp[0][nums[0]]=true;
            if(nums[0]==target)
                return true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <=target ; j++) {
                dp[i][j]=dp[i-1][j];
                if(nums[i]<=j)
                {
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }
                if(dp[i][target])
                    return true;
            }
        }
        return dp[nums.length-1][target];
    }
}