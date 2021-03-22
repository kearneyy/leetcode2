package _56合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution2 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums= new int[][]{{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};
        int[][] merge = merge(nums);
        for (int[] ints : merge) {
            System.out.println(ints[0]+","+ints[1]);
        }
    }
}
