package _376摆动序列;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1])
            {
                list.add(nums[i]);
            }
        }
        if(list.size()==1)
            return 1;
        int count = 1;
        boolean flag = true;
        for (int i = 1; i < list.size()-1; i++) {
            flag= (list.get(i - 1) <= list.get(i) || list.get(i) <= list.get(i + 1)) && (list.get(i - 1) >= list.get(i) || list.get(i) >= list.get(i + 1));
            if(flag)
            {
                count++;
            }
        }
        return count+1;
    }

    public static void main( String[] args) {
        int nums[] =new int[]{1,1,1};
        int i = wiggleMaxLength(nums);
        System.out.println(i);
    }
}
