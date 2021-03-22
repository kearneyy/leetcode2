package _57插入区间;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * 难度
 * 困难
 * <p>
 * 235
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            if (newInterval.length != 0)
                return new int[][]{new int[]{newInterval[0], newInterval[1]}};
        }

        List<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = false;
        int index = 0;
        while (index < intervals.length) {
            if (!flag && intervals[index][0] > right) {
                list.add(new int[]{newInterval[0],newInterval[1]});
                flag = true;
                continue;
            }
            if (intervals[index][0] > right) {
                    list.add(new int[]{intervals[index][0], intervals[index][1]});
                    flag = true;
                index++;
                continue;
            }
            if (intervals[index][1] < left) {
                list.add(new int[]{intervals[index][0], intervals[index][1]});
                index++;
                continue;
            }
            if (intervals[index][1] >= left) {
                flag = true;
                left = Math.min(intervals[index][0], left);
                while (index < intervals.length && right >= intervals[index][0]) {
                    right = Math.max(intervals[index][1], right);
                    index++;
                }
                list.add(new int[]{left, right});
            }

        }
        if (!flag)
            list.add(new int[]{newInterval[0], newInterval[1]});
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] inter = new int[][]
//                {{1,2},{3,5},{6,7},{8,10},{12,16}};
                {{1,3},{6,9}};
//                {{1, 5}};
        int[] newint = new int[]{2,5};
        int[][] insert = insert(inter, newint);
        for (int[] ints : insert) {
            System.out.println(ints[0] + "," + ints[1]);
        }
    }
}