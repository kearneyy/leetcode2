package _1两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 难度
 * 简单
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class twonumbersum {

    public static void main(String[] args) {
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] number = twoSum2(nums, target);
        System.out.println(number[0] + "," + number[1]);

    }


    /**
     * 自己最笨解法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] number = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    number[0] = i;
                    number[1] = j;
                    break;
                }

            }
        }
        return number;
    }

    /**
     * 解法2hash表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n) && map.get(n) != i) {
                return new int[]{i, map.get(n)};
            }
        }
    throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 解法3 利用hash表不重复装入特性 一次装入
     * @param nums
     * @param target
     * @return
     */
        public int[] twoSum3(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i< nums.length; i++) {
                if(map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target-nums[i]),i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }

}
