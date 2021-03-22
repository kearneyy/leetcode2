package 背包问题;

import java.util.Scanner;



//01背包恰好装满,改变初始化确保状态都从dp[0][0]转移来的
public class Solution3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int V[] = new int[n + 1];
        int W[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            V[i] = s.nextInt();
            W[i] = s.nextInt();
        }
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <=m; i++) {
            dp[0][i]=Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= m; j++) {
                if (j >= V[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + W[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }
}
