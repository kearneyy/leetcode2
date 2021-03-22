package _665非递减数列;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 *
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//很容易犯错这题 要考虑两种情况
class Solution {
    public static boolean checkPossibility(int[] nums) {
        int[] tempnum = new int[nums.length+2];
        tempnum[0] = Integer.MIN_VALUE;
        tempnum[tempnum.length-1] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            tempnum[i+1] = nums[i];
        }
        int count = 0;
        for (int i = 0; i < tempnum.length-1; i++) {
            if(tempnum[i]>tempnum[i+1])
            {
                count++;
                if(tempnum[i+1]<tempnum[i-1])
                {
                    tempnum[i+1]=tempnum[i];
                }
                else
                {
                    tempnum[i] = tempnum[i+1];
                }
            }
            if(count>=2)
                break;
        }
        return count<=1;
    }

    public static void main(String[] args) {
        boolean b = checkPossibility(new int[]{5,7,1,8});
        System.out.println(b);
    }
}