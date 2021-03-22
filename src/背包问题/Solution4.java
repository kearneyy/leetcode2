package 背包问题;

import java.util.Scanner;

//完全背包问题，一个东西可以用无数次
public class Solution4 {
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
            for (int j = V[i]; j<=m ; j++) {//滚动数组正序j可以直接从V[i]开始
                dp[j]=Math.max(dp[j],dp[j-V[i]]+W[i]);//这边跟滚动数组那个很像，但这个是正着循环，可以使用刚才更新过的
            }
        }
        System.out.println(dp[m]);
    }
}