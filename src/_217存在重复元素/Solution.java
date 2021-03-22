package _217存在重复元素;

import java.util.*;

class Solution {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]))
            {
                set.add(nums[i]);
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }
}