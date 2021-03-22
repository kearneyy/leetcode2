package 背包问题;

import java.util.Scanner;

//https://www.bilibili.com/video/av33930433
//01背包问题
//背包九讲有个不懂的地方就是为什么有res
//因为初始化的时候把背包dp[0][0]--dp[0][m]都初始化为0了，若不为0，则res要返回dp[n][0]--dp[n][m]的最大值,或者dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + W[i]),dp[i][j-1]);
//dp[i][v]=max{dp[i-1][v],dp[i-1][v-c[i]]+w[i]}，  dp[n][k]表示体积恰好等于k时的最大价值,若初始化的时候把背包dp[0][0]--dp[0][m]都初始化为0了，dp[n][k]表示体积小于等于k的时候最大价值
//dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + W[i]),dp[i][j-1]);，dp[n][k]表示体积小于等于k的时候最大价值，最终答案一定是从dp[0][0]转移来的
/**
 * 用子问题定义状态：即f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则
 * 其状态转移方程便是：f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}。
 *
 * 这个方程非常重要，基本上所有跟背包相关的问题的方程都是由它衍生出来的。
 * 所以有必要将它详细解释一下：“将前i件物品放入容量为v的背包中”这个子问题，
 * 若只考虑第i件物品的策略（放或不放），那么就可以转化为一个只牵扯前i-1件物品的问题。
 * 如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为v的背包中”；如果放第i件物品，
 * 那么问题就转化为“前i-1件物品放入剩下的容量为v-c[i]的背包中”，此时能获得的最
 * 大价值就是f [i-1][v-c[i]]再加上通过放入第i件物品获得的价值w[i]。
 *
 * 注意f[i][v]有意义当且仅当存在一个前i件物品的子集，其费用总和为v。所以按照这个方程递推完毕后，
 * 最终的答案并不一定是f[N] [V]，而是f[N][0..V]的最大值。如果将状态的定义中的“恰”字去掉，
 * 在转移方程中就要再加入一项f[i][v-1]，这样就可以保证f[N] [V]就是最后的答案。至于为什么这样就可以，
 * 由你自己来体会了。
 */

//01背包
public class Solution {
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
        for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= m; j++) {
                if (j >= V[i]) {//不是滚动数组所以要写if和else
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + W[i]),dp[i][j-1]);
                    //可以写成 dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + W[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //可以写成res=dp[n][m];
        int res = 0;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }
}
