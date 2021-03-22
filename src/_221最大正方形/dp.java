package _221最大正方形;


/**
 * 动态规划求法
 *  dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
 */
public class dp {
    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null)
            return maxSize;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }

            }
        }
        return maxSize * maxSize;
    }

}
