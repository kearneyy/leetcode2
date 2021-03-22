package 背包问题;

import java.util.Scanner;

//二维背包问题
public class Solution9 {
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
        int dp[][] = new int[v+1][m+1];
        for (int i = 1; i <=n; i++) {
            for (int j = v; j>=V[i] ; j--) {
                for (int k = m; k >=M[i] ; k--) {
                    dp[j][k]=Math.max(dp[j][k],dp[j-V[i]][k-M[i]]+W[i]);
                }
            }
        }
        System.out.println(dp[v][m]);
    }
}
