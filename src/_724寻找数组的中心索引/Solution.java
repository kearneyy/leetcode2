package _724寻找数组的中心索引;

/**
 * 724. 寻找数组的中心索引
 * 难度
 * 简单
 *
 * 269
 *
 *
 *
 *
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1：
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 */
class Solution {
    public static int pivotIndex(int[] nums) {
        if(nums.length<=3)
            return -1;
        int[] presum  =new int[nums.length+1];
        int[] lastsum = new int[nums.length+1];
        presum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            presum[i+1] =nums[i]+presum[i]; 
        }
        lastsum[nums.length]=0;
        for (int i = nums.length-1; i >=0 ; i--) {
            lastsum[i]=lastsum[i+1]+nums[i];
        }
        int index1 = 0;
        while (index1<presum.length-2)
        {
            if (presum[index1]==lastsum[index1+1])
            {
                return index1;
            }
            index1++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(i);
    }
}