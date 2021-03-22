package 背包问题;

import java.util.Scanner;

//二维背包问题的三维矩阵写法
public class Solution10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int v = s.nextInt();//最大体积
        int m = s.nextInt();//最大重量
        int V[]=new int[n+1];
        int W[]=new int[n+1];
        int M[]=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            V[i]=s.nextInt();
            M[i]=s.nextInt();
            W[i]=s.nextInt();
        }
        int dp[][][] = new int[n+1][v+1][m+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j<=v ; j++) {//这里不能用j=V[i]开始，因为不是滚动数组
                for (int k = 1; k <= m; k++) {
                    if(j>=V[i]&&k>=M[i])
                    {
                        dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j-V[i]][k-M[i]]+W[i]);
                    }
                    else
                    {
                        dp[i][j][k]=dp[i-1][j][k];
                    }

                }
            }
        }
        System.out.println(dp[n][v][m]);
    }
}
