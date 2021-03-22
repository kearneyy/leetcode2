package _322零钱兑换;

import java.util.Arrays;

public class Solution2 {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = new int[]{ 186,419,83,408 };
        int amount = 6249;
        int i = coinChange(coins, amount);
        System.out.println(i);

    }
}
