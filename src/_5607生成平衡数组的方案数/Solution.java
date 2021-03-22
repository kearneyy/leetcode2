package _5607生成平衡数组的方案数;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 *
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 */

//前缀和 用oddeven保存奇数和偶数前缀和
class Solution {
    public static int waysToMakeFair(int[] nums) {
        if(nums.length==1)
            return 1;
        int total = 0;
        int count=0;
        int oddandeven[] = new int[nums.length];
        boolean isodd = nums.length % 2 == 0;
        oddandeven[0]=nums[0];
        oddandeven[1]=nums[1];
        for (int i = 0; i < nums.length; i++) {
            if(i!=0&&i!=1)
            {
                oddandeven[i]=nums[i]+oddandeven[i-2];
            }
            total+=nums[i];
        }
        int temptotal1=0;
        int temptotal2=0;
        for (int i = 1; i < nums.length; i++) {
            temptotal1=total-nums[i];
            temptotal2=temptotal1;
            if((temptotal1)%2==0)
            {
                if(i%2==1)//如果删除的是奇数
                {
                    if (isodd)//如果最后为奇数下标
                    {
                        temptotal2=temptotal2-oddandeven[nums.length-1]+oddandeven[i]-oddandeven[i-1];
                    }
                    else
                    {
                        temptotal2=temptotal2-oddandeven[nums.length-1]+oddandeven[i-1]-oddandeven[i]+nums[i];
                    }
                }
                else
                {
                    if(isodd)
                    {
                        temptotal2=temptotal2-oddandeven[nums.length-1]+oddandeven[i-1]-oddandeven[i]+nums[i];
                    }
                    else
                    {
                        temptotal2=temptotal2-oddandeven[nums.length-1]+oddandeven[i]-oddandeven[i-1];
                    }
                }
                if(temptotal2*2==temptotal1)
                {
                    count++;
                }
            }
        }
        if(isodd)
        {
            if((total-nums[0])==oddandeven[nums.length-1]*2)
            {
                count++;
            }
        }
        else
        {
            if((total-nums[0])==oddandeven[nums.length-2]*2)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,1,6,4};
        int i = waysToMakeFair(nums);
        System.out.println(i);
    }
}
