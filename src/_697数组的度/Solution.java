package _697数组的度;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 *
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//简单题 hash表
class Pernum{
    int count = 0;
    int first = -1;
    int last = -1;
}
class Solution {



    public static int findShortestSubArray(int[] nums) {
        Map<Integer,Pernum> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Pernum pernum;
            if(map.containsKey(nums[i]))
            {
                pernum = map.get(nums[i]);
                pernum.count++;
                pernum.last = i;
            }
            else
            {
                pernum = new Pernum();
                pernum.count++;
                pernum.first = i;
                pernum.last = i;
            }
            map.put(nums[i],pernum);
        }
        int max = 0;
        int minlength = nums.length;
        for (Map.Entry<Integer, Pernum> integerPernumEntry : map.entrySet()) {
            Pernum value = integerPernumEntry.getValue();
            if(value.count>=max)
            {
                if(value.count==max)
                {
                    if(value.last-value.first+1<minlength)
                    {
                        minlength = value.last-value.first+1;
                    }
                }
                else
                {
                        max = value.count;
                        minlength = value.last-value.first+1;

                }
            }
        }
        return minlength;
    }

    public static void main(String[] args) {
        int shortestSubArray = findShortestSubArray(new int[]{1,2,2,3,1,4,2});
        System.out.println(shortestSubArray);
    }
}