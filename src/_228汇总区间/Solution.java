package _228汇总区间;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * 	"a->b" ，如果 a != b
 * 	"a" ，如果 a == b
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = i;
            int last = i;
            boolean flag  = false;
            for (; last< nums.length-1&&nums[last+1]==nums[last]+1; last++)
            {
                if(last==nums.length-2) {
                    flag = true;
                    if (nums[last + 1] == nums[last] + 1) {
                        list.add(nums[first] + "->" + (nums[last] + 1));
                    } else {
                        list.add(String.valueOf(nums[last] + 1));
                    }

                }
            }
            if(!flag) {
                if (first == last) {
                    list.add(String.valueOf(nums[first]));
                } else {
                    list.add(nums[first] + "->" + nums[last]);
                }
            }
            i = last ;
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,4,5,7};
        List<String> list = summaryRanges(nums);
        for (String s : list) {
            System.out.println(s);
        }
    }
}