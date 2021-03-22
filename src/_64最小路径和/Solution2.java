package _64最小路径和;

/**
 * 64. 最小路径和
 * 难度
 * 中等
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
//滚动数组
class Solution2 {
    public static int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int m = grid.length;//行数
        int n = grid[0].length;//列数
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j != 0)
                        dp[j] = grid[i][j] + dp[j - 1];
                } else {
                    if (j == 0) {
                        dp[j] = grid[i][j] + dp[j];
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                    }
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] num = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(num));
    }
}