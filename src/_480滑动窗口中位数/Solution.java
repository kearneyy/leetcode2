package _480滑动窗口中位数;

import java.util.*;

/**
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 *
 * 	[2,3,4]，中位数是 3
 * 	[2,3]，中位数是 (2 + 3) / 2 = 2.5
 *
 *
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *
 *
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> list = new ArrayList<Double>(k);
        double[] temp = new double[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < k; i++) {
            list.add(temp[i]);
        }
        double[] res = new double[nums.length-k+1];
        int resindex = 0;
        for (int i = k; i < nums.length; i++) {
            double mid = getmid(list, k);
            res[resindex++] = mid;
            list.remove((double)nums[i-k]);
            addin(list,nums[i]);
        }
        double mid = getmid(list, k);
        res[resindex] = mid;
        return res;
    }

    private static void addin(List<Double> list, double num) {
        int left = 0;
        int right = list.size()-1;
        while (left <=right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < num) {
                left = mid+1 ;
            } else {
                right = mid - 1;
            }
        }
        list.add(left, num);
    }

    public static double getmid(List<Double> list, int k)
    {
        if(k%2==0)
        {
            double left = list.get((k-1)/2);
            double right = list.get(k/2);
            return (left+right)/2;
        }
        else
        {
            return list.get(k/2);
        }
    }

    public static void main(String[] args) {
        double[] doubles = medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }
}