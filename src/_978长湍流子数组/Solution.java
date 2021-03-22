package _978长湍流子数组;

/**
 * 978. 最长湍流子数组
 * 难度
 * 中等
 *
 * 123
 *
 *
 *
 *
 *
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 *
 * 示例 1：
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * 输入：[100]
 * 输出：1
 */

//通过简单 但是效率低
class Solution {
    public static int maxTurbulenceSize(int[] arr) {
        int max = 0;
        int count = 0;
        int index = 0;
        int len = arr.length;
        while (index<len-1)
        {
            if(index%2==0)
            {
                if(arr[index]<arr[index+1])
                {
                    count++;
                }
                else
                {
                    count=0;
                }
                index++;
            }
            else
            {
                if(arr[index]>arr[index+1])
                {
                    count++;
                }
                else
                {
                    count=0;
                }
                index++;
            }
            max = Math.max(count,max);
        }
        count = 0;
        index = 0;
        while (index<len-1)
        {
            if(index%2==0)
            {
                if(arr[index]>arr[index+1])
                {
                    count++;
                }
                else
                {
                    count=0;
                }
                index++;
            }
            else
            {
                if(arr[index]<arr[index+1])
                {
                    count++;
                }
                else
                {
                    count=0;
                }
                index++;
            }
            max = Math.max(count,max);
        }
        return max+1;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{0,1,1,0,1,0,1,1,0,0};
        int i = maxTurbulenceSize(arr);
        System.out.println(i);
    }
}