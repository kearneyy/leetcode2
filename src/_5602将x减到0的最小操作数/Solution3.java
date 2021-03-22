package _5602将x减到0的最小操作数;

import java.util.Arrays;



//本题类似186周周赛的第二题可获得的最大点数，找外部最小即找中间最大
//找长度最大的那个子数组和会等于sum(nums)-x
//窗口不断变大伸缩，然后最后直到left也到最后
public class Solution3 {
    public static int minOperations(int[] nums, int x) {
       int maxpart=-1;
       int sum = Arrays.stream(nums).sum();
       int left=0;
       int right=0;
       int currsum = 0;
       while (left<nums.length)
       {
           if(right<nums.length)
            currsum+=nums[right++];
            while (currsum>sum-x&&left<nums.length){
                currsum-=nums[left++];
            }
            if(currsum==sum-x)
            {
                maxpart=Math.max(maxpart,right-left);
            }
            if(right==nums.length&&currsum<=sum-x)
                break;
            //right到最后了，前缀只会越来越小，可以直接break了
//           if(right==nums.length)
//               right++;
           //这里两种都可以用，只是用于结束循环
       }
       return maxpart ==-1? -1:nums.length-maxpart;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,3,2,5};
        int i = minOperations(nums, 5);
        System.out.println(i);
    }
}
