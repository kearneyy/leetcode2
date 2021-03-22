package _452用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 * 输入：points = [[1,2]]
 * 示例 5：
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//1,4 2,5,3,8
//排序+贪心 将每个数组按照右边界进行排序
class Solution {
    public static int findMinArrowShots(int[][] points) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        };
        Arrays.sort(points,comparator);
        int count=0;
        int index=0;
        while (index<points.length)
        {
            count++;
            int right = points[index][1];
            index++;
            while (index<points.length&&points[index][0]<=right)
            {
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] nums =  new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int[][] nums =  new int[][]{{2,3},{2,3}};
//        int[][] nums =  new int[][]{{1,2},{3,4},{5,6},{7,8}};
        int minArrowShots = findMinArrowShots(nums);
        System.out.println(minArrowShots);
    }
}