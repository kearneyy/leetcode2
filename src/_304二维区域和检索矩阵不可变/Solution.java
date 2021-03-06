package _304二维区域和检索矩阵不可变;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 难度
 * 中等
 *
 * 179
 *
 *
 *
 *
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 *
 * 示例：
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
class NumMatrix {
    int row;
    int col;
    int[][] presumMatrix;

    public NumMatrix(int[][] matrix) {
        row =matrix.length+1;
        if(matrix.length==0)
            return;
        col =matrix[0].length+1;
        presumMatrix = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                presumMatrix[i][j] = presumMatrix[i-1][j]+presumMatrix[i][j-1]-presumMatrix[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return presumMatrix[row2+1][col2+1]+presumMatrix[row1][col1]-presumMatrix[row1][col2+1]-presumMatrix[row2+1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix=  new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix m = new NumMatrix(matrix);
        int i = m.sumRegion(2, 1, 4, 3);
        System.out.println(i);
    }
}
