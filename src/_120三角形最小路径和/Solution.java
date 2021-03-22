package _120三角形最小路径和;
/**
 * 120. 三角形最小路径和
 * 难度
 * 中等
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */

//思路 利用动态规划 构造一个左上角三角形 第一个矩阵用于记录三角形，第二个矩阵用于记录最短距离
//DP+贪心

import java.util.LinkedList;
import java.util.List;

/**
 * 第一个矩阵：
 * 2 4 7 3
 * 3 5 8
 * 6 1
 * 4
 *
 * 2 3 6 4
 * 4 5 1
 * 7 8
 * 3
 * 每次只能往右或者往下移动
 *
 * 第二个矩阵用于记录最短路程
 * 2 6 13 16
 * 5 10 18
 * 11 11
 * 15
 *
 * 对角线上最小的数字即为最短路程
 */
class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        //首先构造一个矩阵
        int length = triangle.size();
        if(length==1)
        return triangle.get(0).get(0);
        int[][] number =new int[length][length];
        for (int i = 0; i < length; i++) {
            int k=0;
            for (int j = i; j >=0 ; j--) {
                List<Integer> list = triangle.get(i);
                number[k][j]=list.get(j);
                k++;
            }
        }
         /*将triangle转化为了数组
         *  2 4 7 3
         *  3 5 8
         *  6 1
         *  4
         *  *
         */
        int[][] dp =new int[length][length];
        dp[0][0]=number[0][0];
        for (int i = 1; i < length; i++) {
            dp[0][i] = number[0][i]+dp[0][i-1];
            dp[i][0] = number[i][0]+dp[i-1][0];
        }
        /*
         * 2  6 13 16
         * 5  0 0 0
         * 11 0 0 0
         * 15 0 0 0
         */

        for (int i = 2; i <length; i++) {
            for (int j = 1; j < i; j++) {
                dp[j][i-j]=Math.min(dp[j-1][i-j]+number[j][i-j],dp[j][i-j-1]+number[j][i-j]);
            }
        }//动态规划 斜着遍历

        int min=dp[0][length-1];
        for (int i = 1; i < length; i++) {
            if(dp[i][length-1-i]<min)
                min=dp[i][length-1-i];
        }//查询对角线最小的哪个数字

        return min;
    }

    /**
     * class Solution {
     *     public int minimumTotal(List<List<Integer>> triangle) {
     *         int n = triangle.size();
     *         // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
     *         int[][] dp = new int[n + 1][n + 1];
     *         // 从三角形的最后一行开始递推。
     *         for (int i = n - 1; i >= 0; i--) {
     *             for (int j = 0; j <= i; j++) {
     *                 dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
     *             }
     *         }
     *         return dp[0][0];
     *     }
     * }
     *
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);

        List<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = new LinkedList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List<Integer> list4 = new LinkedList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        List<List<Integer>> lists = new LinkedList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        int min = minimumTotal(lists);
        System.out.println(min);
    }

}
