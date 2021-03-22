package _1004最大连续1的个数III;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int count = 0;
        for (; right < A.length; right++) {
            if (A[right] == 0)
                count++;
            if(count>=K)
                break;
        }
        if(right==A.length)
            return right-left;
        while (right < A.length) {
            if(count<=K)
            {
                while (right+1<A.length&&A[right+1]==1)
                {
                    right++;
                }
            }
            right++;
            if(right<A.length&&A[right]==0)
            {
                count++;
            }
            if(A[left]==0)
            {
                count--;
            }
            left++;
        }
        return right>left?right-left+1:0;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] A = new int[]{
                0,0,0,0};
//        int i = longestOnes(A, 2);
        int i = longestOnes(A, 0);
        System.out.println(i);
    }
}
