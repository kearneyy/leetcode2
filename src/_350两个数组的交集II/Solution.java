package _350两个数组的交集II;

import java.util.Arrays;

/**
 * 350. 两个数组的交集 II
 * 难度
 * 简单
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 */

//法一，排序后对两个数组检索
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0, index1 = 0, index2 = 0;
        int[] num = new int[Math.min(nums1.length, nums2.length)];
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                num[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(num,0,index);
    }
}
