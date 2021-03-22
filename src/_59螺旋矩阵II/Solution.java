package _59螺旋矩阵II;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public static int[][] generateMatrix(int n) {
        int count = 1;
        int[][] nums = new int[n][n];
        int x = 0;
        int y = 0;
        nums[0][0] = 1;
        while (count < n*n) {
            while (y + 1 < n && nums[x][y + 1]==0) {
                y = y + 1;
                nums[x][y] = ++count;
            }
            while (x + 1 < n && nums[x+1][y]==0) {
                x = x + 1;
                nums[x][y] = ++count;
            }
            while (y -1 >=0  && nums[x][y-1]==0) {
                y = y - 1;
                nums[x][y] = ++count;
            }
            while (x -1 >=0 &&  nums[x-1][y]==0) {
                x = x - 1;
                nums[x][y] = ++count;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(ints[i][j]);
            }
            System.out.println();
        }
    }
}