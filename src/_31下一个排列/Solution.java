package _31下一个排列;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void nextPermutation(int[] nums) {
        if(nums.length==0||nums.length==1)
            return;
        int i=nums.length-1;
        boolean flag=false;
        for (; i >=1; i--) {
            if(nums[i]>nums[i-1])
            {
                flag=true;
                break;
            }
        }
        if(flag)
        {
           int index=i-1;
           int min=nums[index+1];
           int minindex=0;
            for (int j = index; j <nums.length ; j++) {
                if(nums[j]<=min&&nums[j]>nums[index])
                {
                    min=nums[j];
                    minindex=j;
                }
            }

            swap(nums,index,minindex);
            reverse(nums,index+1);
        }
        else
        {
            reverse(nums,0);
        }
    }

//    public static void quick(){
//
//    }

//    public static void select(int[] nums,int left){
//        for (int i = left; i <nums.length; i++) {
//            int min = nums[i];
//            int minindex = i;
//            for (int j = i; j < nums.length; j++) {
//                if (nums[j] < min) {
//                    min = nums[j];
//                    minindex = j;
//                }
//            }
//            if (minindex != i)
//            {
//                int temp = nums[i];
//                nums[i]=min;
//                nums[minindex]=temp;
//            }
//        }
//    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        int nums[] = new int[]{3,2,1};
        nextPermutation(nums);
    }
}