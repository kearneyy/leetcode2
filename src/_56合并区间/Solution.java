package _56合并区间;

import java.util.*;

/**
 * 56. 合并区间
 * 难度
 * 中等
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

class Solution {

    public static int[][] merge(int[][] intervals) {
        Comparator<int[]> comparator =new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };
        Arrays.sort(intervals,comparator);

        List<int[]> merged = new ArrayList<>();
        int index=0;
        int max=0;
        while (index<intervals.length-1)
        {
             max=intervals[index][1];
            int min=intervals[index][0];
            do {
                if(index+1==intervals.length)
                    break;
                int firstnum = intervals[index+1][0];
                int secondnum = intervals[index+1][1];
                if(firstnum<=max)
                {
                    min = Math.min(min,firstnum);
                    max = Math.max(max,secondnum);
                }
                index++;
            }while (intervals[index][0]<=max);
            merged.add(new int[]{min,max});
        }
        if(index==intervals.length-1&&max<intervals[index][1])
            merged.add(new int[]{intervals[index][0],intervals[index][1]});
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
//        int[][] nums= new int[][]{{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};
        int[][] nums= new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        int[][] nums= new int[][]
//                {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] merge = merge(nums);
        for (int[] ints : merge) {
            System.out.println(ints[0]+","+ints[1]);
        }
    }
}