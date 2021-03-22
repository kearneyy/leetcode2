package _75颜色分类;

//双指针
class Solution2 {
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int p0=0;
        int p2=nums.length-1;
        for (int i = p0; i <p2 ; i++) {
            if(nums[i]==0)
            {
                nums[i]=nums[p0];
                nums[p0]=0;
                p0++;
            }
            else if(nums[i]==2)
            {
                nums[i]=nums[p2];
                nums[p2]=2;
                p2--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
        System.out.println("a");
    }
}