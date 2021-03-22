package _5618K和数对的最大数目;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * 示例 2：
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 */
//写的太乱
class Solution {
    public static int maxOperations(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))) {
                ArrayList<Integer> list1 = map.get(list.get(i));
                list1.add(i);
                map.put(list.get(i), list1);
            } else {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(i);
                map.put(list.get(i), list1);
            }
        }
        int count=0;
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(k - list.get(i))) {
                ArrayList<Integer> list1 = map.get(list.get(i));
                if (list.get(i)*2 == k ) {
                    if (list1.size() == 1) {
                        continue;
                    }
                    else
                    {
                        list1.remove(0);
                        list1.remove(0);
                        i++;
                        count++;
                        continue;
                    }

                }
                int num1 = list.get(i);
                ArrayList<Integer> list2 = map.get(k - list.get(i));
                list.set((int) list2.get(0), Integer.MAX_VALUE);
                list2.remove(0);

                if (list2.size() == 0) {
                    map.remove(k - num1);

                }
                list.set((int) list1.get(0),Integer.MAX_VALUE);
                list1.remove(0);
                if (list1.size() == 0) {
                    map.remove(num1);
                }
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int i = maxOperations(nums, 3);
        System.out.println(i);
    }
}