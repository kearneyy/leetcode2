package _659分割数组为连续子序列;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），
 * 请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
 * 使用两个哈希表，第一个哈希表存储数组中的每个数字的剩余次数，第二个哈希表存储数组中的每个数字作为结尾的子序列的数量。
 * 初始时，每个数字的剩余次数即为每个数字在数组中出现的次数，因此遍历数组，初始化第一个哈希表。
 * 在初始化第一个哈希表之后，遍历数组，更新两个哈希表。只有当一个数字的剩余次数大于 000 时
 * ，才需要考虑这个数字是否属于某个子序列。假设当前元素是 xxx，进行如下操作。
 * 首先判断是否存在以 x−1x-1x−1 结尾的子序列，即根据第二个哈希表判断 x−1x-1x−1
 * 作为结尾的子序列的数量是否大于 000，如果大于 000，则将元素 xxx 加入该子序列中。
 * 由于 xxx 被使用了一次，因此需要
 * 在第一个哈希表中将 xxx 的剩余次数减 111。又由于该子序列的最后一个数字从 x−1x-1x−1
 * 变成了 xxx，因此需要在第二个哈希表中将 x−1x-1x−1 作为结尾的子序列的数量减 111，以及将 xxx 作为结尾的子序列的数量加 111。
 * 否则，xxx 为一个子序列的第一个数，为了得到长度至少为 333 的子序列，x+1x+1x+1
 * 和 x+2x+2x+2 必须在子序列中，因此需要判断在第一个哈希表中 x+1x+1x+1 和 x+2x+2x+2的剩余次数是否都大于 000。
 * 当 x+1x+1x+1 和 x+2x+2x+2 的剩余次数都大于 000 时，可以新建一个长度为 333
 * 子序列 [x,x+1,x+2][x,x+1,x+2][x,x+1,x+2]。由于这三个数都被使用了一次，因此需要
 * 在第一个哈希表中将这三个数的剩余次数分别减 111。又由于该子序列的最后一
 * 个数字是 x+2x+2x+2，因此需要在第二个哈希表中将 x+2x+2x+2 作为结尾的子序列的数量加 111。
 * 否则，无法得到长度为 333 的子序列 [x,x+1,x+2][x,x+1,x+2][x,x+1,x+2]，因此无法完成分割，返回 false\text{false}false。
 * 如果整个数组遍历结束时，没有遇到无法完成分割的情况，则可以完成分割，返回 true\text{true}true。
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/solution/fen-ge-shu-zu-wei-lian-xu-zi-xu-lie-by-l-lbs5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//参考题解贪心算法
class Solution {
    public static boolean isPossible(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();//用于存放每个数字的出现次数
        Map<Integer,Integer> endMap  = new HashMap<>();//用于存放子数组的最后一个数字
        for (int i = 0; i < nums.length; i++) {
            int count = countMap.getOrDefault(nums[i],0)+1;
            countMap.put(nums[i],count);
        }
        for (int i = 0; i < nums.length; i++) {
            int count = countMap.getOrDefault(nums[i],0);
            if(count>0)
            {
                int preEndCount = endMap.getOrDefault(nums[i]-1,0);//如果前一个数有作为结尾
                //可以考虑要不要把当前数加入，那么第一个表的x就要-1，第二个表的x-1就要-1 x+1
                if(preEndCount>0)
                {
                    countMap.put(nums[i],count-1);
                    endMap.put(nums[i]-1,preEndCount-1);
                    endMap.put(nums[i],endMap.getOrDefault(nums[i],0)+1);
                }
                else//否则 如果 第一个表的x+1 x+2大于0  那么就创建一个新的子序列
                //那么第一个表x+1 x+2都减1 第二个表的x+2加1
                {
                    int count1 = countMap.getOrDefault(nums[i]+1,0);
                    int count2 = countMap.getOrDefault(nums[i]+2,0);
                    if(count1>0&&count2>0)
                    {
                        countMap.put(nums[i],count-1);
                        countMap.put(nums[i]+1,count1-1);
                        countMap.put(nums[i]+2,count2-1);
                        endMap.put(nums[i]+2,endMap.getOrDefault(nums[i]+2,0)+1);
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,3,4,5};
        System.out.println(isPossible(nums));
    }
}
