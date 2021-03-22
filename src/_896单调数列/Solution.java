package _896单调数列;

/**
 * 896. 单调数列
 * 难度
 * 简单
 *
 * 121
 *
 *
 *
 *
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 */

//遍历一遍
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length<=1)
        {
            return true;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if(A[0]<=A[1])
        {
            int i = 1;
            for (;i<A.length-1;i++)
            {
                if(A[i]>A[i+1])
                    break;
            }
            flag1=i==A.length-1;
        }
        if(A[0]>=A[1])
        {
            int i = 1;
            for (;i<A.length-1;i++)
            {
                if(A[i]<A[i+1])
                    break;
            }
            flag2=i==A.length-1;
        }
        return flag1||flag2;
    }
}