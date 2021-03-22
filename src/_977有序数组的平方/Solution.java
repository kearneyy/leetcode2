package _977有序数组的平方;

/**
 * 977. 有序数组的平方
 * 难度
 * 简单
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 双指针
 */
class Solution {
    public static int[] sortedSquares(int[] A) {
        int size = A.length;
        int[] nums = new int[size];
        if (A[0] >= 0) {
            for (int i = 0; i < size; i++) {
                nums[i] = A[i] * A[i];
            }
            return nums;
        }
        if (A[size - 1] <= 0) {
            for (int i = 0; i < size; i++) {
                nums[i] = A[size - 1 - i] * A[size - 1 - i];
            }
            return nums;
        }
        int index = 0;
        for (int i = 0; i < size-1; i++) {
            if(A[i]<0&&A[i+1]>=0)
            {
                index=i+1;
                break;
            }

    }
        int right=index;
        int left=index-1;
        int numsindex=0;
        while(left>=0&&right<size)
        {
            int leftnum = A[left]*A[left];
            int rightnum = A[right]*A[right];
            if(leftnum>=rightnum)
            {
                nums[numsindex]=rightnum;
                right++;
            }
            else
            {
                nums[numsindex]=leftnum;
                left--;
            }
            numsindex++;
        }
        if(left<0)
        {
            while (right<size)
            {
                nums[numsindex++]=A[right]*A[right];
                right++;
            }
        }
        if(right==size)
        {
            while (left>=0)
            {
                nums[numsindex++]=A[left]*A[left];
                left--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = sortedSquares(new int[]{1,2,3,4,5});
        for (int num : nums) {
            System.out.println(num);
        }
    }
}