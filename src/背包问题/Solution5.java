package 背包问题;

import java.util.Scanner;

//完全背包问题，一个东西可以用无数次,另一种解法
public class Solution5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int V[]=new int[n+1];
        int W[]=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            V[i]=s.nextInt();
            W[i]=s.nextInt();
        }
        int dp[] = new int[m+1];
        for (int i = 1; i <=n; i++) {
            for (int j = m; j>=V[i] ; j--) {
                for (int k = 0; k *V[i]<=j ; k++) {
                    dp[j]=Math.max(dp[j],dp[j-k*V[i]]+k*W[i]);
                }
            }
        }
        System.out.println(dp[m]);
    }
}