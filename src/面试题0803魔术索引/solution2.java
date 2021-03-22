package 面试题0803魔术索引;
//暴力优化，如果相等返回，大了就前进，小了就跳到对应数字的索引
public class solution2 {
    public static int findMagicIndex(int[] nums) {
       int i=0;
        while (i<nums.length)
       {
           if(i==nums[i])
               return i;
           else if (i>nums[i])
               i++;
           else
               i=nums[i];
       }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMagicIndex(new int[]{1,1,1}));
    }
}
