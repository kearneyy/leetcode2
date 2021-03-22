package _152乘积最大子数组;

/**
 * 152. 乘积最大子数组
 * 难度
 * 中等

 * 给你一个整数数组 nums ，请你找出数组中乘积最
 * 大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 暴力解法
 */
class Solution {
    public static int maxProduct(int[] nums) {
        double max = Double.NEGATIVE_INFINITY;
        int len = nums.length;
        for(int i=0;i<len;i++)
        {
            int temp=0;
            for(int j=i;j<len;j++)
            {
                if(i==j)
                {
                    temp=nums[i];
                    if(temp>=max)
                    {
                        max=temp;
                    }
                }
                else
                {
                    temp*=nums[j];
                    if(temp>=max)
                    {
                        max=temp;
                    }
                }
            }
        }
        return (int)max;
    }

    public static void main(String[] args) {
        int[] num = {-2,3,-4};
        int max = maxProduct(num);
        System.out.println(max);
    }
}