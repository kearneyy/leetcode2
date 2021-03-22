package _39组合总和;

import java.util.*;

/**
 * 39. 组合总和
 * 难度
 * 中等
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 9:21
 * 失败案例，不能这么写，并不是两两相加，可能有很多个数字相加，错误解法
 * 思路是找出每个数的倍数，然后两两相加凑成target
 *
 */
class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, List<List<Integer>>> map = new TreeMap<>();
        int mul = 1;
        int total = 0;
        for (int candidate : candidates) {
            mul = 1;
            total = 0;
            while (total + candidate <= target) {
                total = mul * candidate;
                List<Integer> templist = new ArrayList<>();
                for (int j = 0; j < mul; j++) {
                    templist.add(candidate);
                }
                if (map.containsKey(total)) {
                    List<List<Integer>> templists = map.get(total);
                    templists.add(templist);
                } else {
                    List<List<Integer>> templists = new ArrayList<>();
                    templists.add(templist);
                    map.put(total, templists);
                }
                mul++;
            }
        }
        int index = 0;
        int[] nums = new int[map.size()];
        for (Integer key : map.keySet()) {
            nums[index++] = key;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    if(nums[i]!=nums[j])
                    {
                        List<List<Integer>> lists1 = map.get(nums[i]);
                        List<List<Integer>> lists2 = map.get(nums[j]);
                        for (List<Integer> list1 : lists1) {
                            for (List<Integer> list2 : lists2) {
                                List<Integer> list = new ArrayList<>();
                                list.addAll(list1);
                                list.addAll(list2);
                                set.add(list);
                            }
                        }
                    }
                    else
                    {
                        List<List<Integer>> lists1 = map.get(nums[i]);
                        for (int k = 0; k < lists1.size(); k++) {
                            for (int l = k; l < lists1.size(); l++) {
                                List<Integer> list1 = lists1.get(k);
                                List<Integer> list2 = lists1.get(l);
                                List<Integer> list = new ArrayList<>();
                                list.addAll(list1);
                                list.addAll(list2);
                                set.add(list);
                            }
                        }
                    }
                }
                else if(nums[i] + nums[j]> target)
                {
                    break;
                }
            }
        }
        if(nums.length>0&&nums[nums.length-1]==target)
        {
            List<List<Integer>> li = map.get(nums[nums.length - 1]);
            set.addAll(li);
        }
        lists.addAll(set);
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{7,3,2}, 18);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}