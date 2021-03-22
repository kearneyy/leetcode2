package _54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = m * n;
        int x = 0;
        int y = 0;
        List<Integer> list = new ArrayList<>();
        list.add(matrix[x][y]);
        visited[x][y]=true;
        count--;
        while (count != 0) {
            while (y + 1 < n && !visited[x][y + 1]) {
                y = y + 1;
                visited[x][y] = true;
                list.add(matrix[x][y]);
                count--;
                if(count==0)
                {
                    return list;
                }
            }
            while (x + 1 < m && !visited[x+1][y]) {
                x = x + 1;
                visited[x][y] = true;
                list.add(matrix[x][y]);
                count--;
                if(count==0)
                {
                    return list;
                }
            }
            while (y -1 >=0  && !visited[x][y-1]) {
                y = y - 1;
                visited[x][y] = true;
                list.add(matrix[x][y]);
                count--;
                if(count==0)
                {
                    return list;
                }
            }
            while (x -1 >=0 && !visited[x-1][y]) {
                x = x - 1;
                visited[x][y] = true;
                list.add(matrix[x][y]);
                count--;
                if(count==0)
                {
                    return list;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (Integer integer : list) {

            System.out.println(integer);
        }
    }
}