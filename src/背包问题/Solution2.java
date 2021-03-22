package 背包问题;

import java.util.Scanner;

//01背包问题滚动数组优化
//j此时应该逆着
//因为顺着的话 dp[j-V[i]]此时是 dp[i][j-V[i]]而不是dp[i-1][j-V[i]]，不像之前有i-1限制，算到此时的时候已经被替换了
public class Solution2 {
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
                    dp[j]=Math.max(dp[j],dp[j-V[i]]+W[i]);
            }
        }
        System.out.println(dp[m]);
    }
}