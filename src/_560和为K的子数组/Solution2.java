package _560和为K的子数组;


/**
 * 暴力法优化
 */
public class Solution2 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for(int left= 0;left<len;left++)
        {
            int sum=0;
            for(int right = left;right<len;right++)
            {
                sum+=nums[right];
                if(sum==k)
                {
                    count++;
                }
            }

        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        Solution2 solution = new Solution2();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}
