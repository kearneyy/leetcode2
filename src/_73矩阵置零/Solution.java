package _73矩阵置零;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if(matrix[i][j]==0)
                {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        for (Integer integer : set1) {
            for (int i = 0; i < n; i++) {
                matrix[integer][i] = 0;
            }
        }

        for (Integer integer : set2) {
            for (int i = 0; i < m; i++) {
                matrix[i][integer] = 0;
            }
        }
    }
}