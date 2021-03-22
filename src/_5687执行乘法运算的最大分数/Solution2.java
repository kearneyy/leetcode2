package _5687执行乘法运算的最大分数;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
 * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
 * 选择数组 nums 开头处或者末尾处 的整数 x 。
 * 你获得 multipliers[i] * x 分，并累加到你的分数中。
 * 将 x 从数组 nums 中移除。
 * 在执行 m 步操作后，返回 最大 分数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3], multipliers = [3,2,1]
 * 输出：14
 * 解释：一种最优解决方案如下：
 * - 选择末尾处的整数 3 ，[1,2,3] ，得 3 * 3 = 9 分，累加到分数中。
 * - 选择末尾处的整数 2 ，[1,2] ，得 2 * 2 = 4 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[1] ，得 1 * 1 = 1 分，累加到分数中。
 * 总分数为 9 + 4 + 1 = 14 。
 * 示例 2：
 * 输入：nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * 输出：102
 * 解释：一种最优解决方案如下：
 * - 选择开头处的整数 -5 ，[-5,-3,-3,-2,7,1] ，得 -5 * -10 = 50 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-3,-2,7,1] ，得 -3 * -5 = 15 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-2,7,1] ，得 -3 * 3 = -9 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[-2,7,1] ，得 1 * 4 = 4 分，累加到分数中。
 * - 选择末尾处的整数 7 ，[-2,7] ，得 7 * 6 = 42 分，累加到分数中。
 * 总分数为 50 + 15 - 9 + 4 + 42 = 102 。
 */
class Solution2 {
    public static int maximumScore(int[] nums, int[] multipliers) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int max = 0;
        int lennums = nums.length;
        int lenmul = multipliers.length;
        for (int i = 0; i < lenmul; i++) {
            list1.add(nums[i]);
        }
        max = Math.max(max, getMax(list1, list2, multipliers));
        int index1 = lennums - 1;
        for (int i = 0; i < lenmul; i++) {
            list1.remove(list1.size() - 1);
            list2.add(nums[index1]);
            int tempmax = getMax(list1, list2, multipliers);
            max = Math.max(max, tempmax);
        }
        return max;
    }

    public static int getMax(List<Integer> list1, List<Integer> list2, int[] multipliers) {
        if (list1.size() != 0 && list2.size() != 0) {
            int[][] dp = new int[list2.size() + 1][list1.size() + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = list2.get(i);
            }
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = list1.get(i);
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j] + multipliers[i] * dp[0][j], dp[i][j - 1] + multipliers[i] * dp[i][0]);
                }
            }
            return dp[list1.size()][list2.size()];
        } else {
            int total = 0;
            if (list2.size() == 0) {

                for (int i = 0; i < list1.size(); i++) {
                    total += list1.get(i) * multipliers[i];
                }

            } else {
                for (int i = 0; i < list2.size(); i++) {
                    total += list2.get(i) * multipliers[i];
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        int i = maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(i);
    }
}