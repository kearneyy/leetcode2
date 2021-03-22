package 背包问题;

import java.util.Scanner;

//分组背包问题,20行和23行自己稍微有些改动
public class Solution12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int dp[]  =new int[v+1];
        for (int i =0; i <n; i++) {
            int s = sc.nextInt();
            int V[] = new int[s];
            int W[] = new int[s];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < s; j++) {
                V[j]=sc.nextInt();
                if(V[j]<min)
                    min=V[j];
                W[j]=sc.nextInt();
            }
            for (int j = v; j >=min ; j--) {//这里不是j>=V[x]这里V存着各个情况的v
                for (int k = 0; k < s; k++) {
                    if(j>=V[k])
                    {
                        dp[j]=Math.max(dp[j],dp[j-V[k]]+W[k]);
                    }
                }
            }
        }
        System.out.println(dp[v]);
    }
}
