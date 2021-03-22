package _435无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 难度
 * 中等
 *
 * 294
 *
 *
 *
 *
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
class Solution {
    public  static  int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        };

        Arrays.sort(intervals,comparator);

        int count=0;

        int index=0;
        while (index<intervals.length)
        {
         int num = intervals[index++][1];
         while (index<intervals.length&&intervals[index][0]<num)
         {
             count++;
             index++;
         }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = eraseOverlapIntervals(new int[][]{{1, 2}, {2,3}});
        System.out.println(i);
    }
}
