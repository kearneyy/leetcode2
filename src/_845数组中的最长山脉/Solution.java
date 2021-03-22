package _845数组中的最长山脉;

/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * 	B.length >= 3
 * 	存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


//找出山顶向两边扩散
class Solution {
    public static int longestMountain(int[] A) {
        int maxM=0;
        for (int i = 1; i < A.length-1; i++) {
            if(A[i]>A[i-1]&&A[i]>A[i+1]) {
                int left = i - 1;
                int right = i + 1;
                while (left-1 >= 0 && A[left - 1] < A[left]) {
                    left--;
                }
                while (right+1 < A.length && A[right + 1] < A[right]) {
                    right++;
                }
                maxM = Math.max(maxM, right - left+1);
                i = right;
            }
        }
        return maxM;
    }

        public static void main(String[] args) {
            int i = longestMountain(new int[]{875,884,239,731,723,685});
            System.out.println(i);
        }
}