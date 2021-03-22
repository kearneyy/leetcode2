package _322零钱兑换;

import java.util.Arrays;

public class Solution3 {
    public static int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 0; i <coins.length ; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int coins[] = new int[]{ 1,2,5};
        int amount = 11;
        int i = coinChange(coins, amount);
        System.out.println(i);

    }
}
