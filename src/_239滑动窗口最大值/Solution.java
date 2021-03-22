package _239滑动窗口最大值;

import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 *
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 *
 *
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2)
            return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i])
            {
                queue.pollLast();
            }
            queue.addLast(i);
            if(queue.peekFirst()<=i-k)
            {
                queue.pollFirst();
            }
            if(i+1>=k)
            {
                result[i+1-k]=nums[queue.peekFirst()];
            }
        }
        return result;
    }
}