package _922按奇偶排序数组II;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static int[] sortArrayByParityII(int[] A) {
        int[] nums = new int[A.length];
        int odd = 1;
        int even = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]%2==0)
            {
                nums[even]=A[i];
                even+=2;
            }
            if(A[i]%2==1)
            {
                nums[odd]=A[i];
                odd+=2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int num[] = new int[]{2,1};
        int[] ints = sortArrayByParityII(num);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}