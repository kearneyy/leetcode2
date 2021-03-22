package 背包问题;

import java.util.Scanner;

//分组背包问题
public class Solution11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int dp[]  =new int[v+1];
        for (int i =0; i <n; i++) {
            int s = sc.nextInt();
            int V[] = new int[s];
            int W[] = new int[s];
            for (int j = 0; j < s; j++) {
                V[j]=sc.nextInt();
                W[j]=sc.nextInt();
            }
            for (int j = v; j >=0 ; j--) {
                for (int k = 0; k < s; k++) {
                    if(j>=V[k])//这里别漏了判断
                    {
                        dp[j]=Math.max(dp[j],dp[j-V[k]]+W[k]);
                    }
                }
            }
        }
        System.out.println(dp[v]);
    }
}
