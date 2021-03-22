package _15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 需要用双指针
 */
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length <= 2) return lists;
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length;
        while ( i < n - 2&&nums[i] <= 0 ) {
            int base = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = base + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(base);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left = moveRight(nums, left + 1);
                    right = moveLeft(nums, right - 1);
                } else if (sum < 0) {
                    left = moveRight(nums, left + 1);
                } else
                    right = moveLeft(nums, right - 1);
            }
            i = moveRight(nums, i + 1);
        }
        return lists;
    }

    private static int moveLeft(int[] nums, int i) {
        while (i>= 0 && nums[i] == nums[i+1]) {
            i--;
        }
        return i;
    }

    private static int moveRight(int[] nums, int i) {
        while (i< nums.length && nums[i] == nums[i-1]) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, 4});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
