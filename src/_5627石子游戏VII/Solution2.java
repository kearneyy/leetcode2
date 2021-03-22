package _5627石子游戏VII;


//博弈论 求最坏情况下最好 dp[i][j] 表示该人先手最坏情况下的最好分数
//很难
class Solution2 {
    public int stoneGameVII(int[] stones) {
        int dp[][] = new int[stones.length+1][stones.length+1];
        int sum[] = new int[stones.length+1];
        //前缀和通常从1开始
        for (int i = 1; i <=stones.length; i++) {
            sum[i]=sum[i-1]+stones[i-1  ];
        }

        //区间dp 先枚举区间长度 最少为2 因为如果为1 拿走了一个后都为0
        for (int len = 2; len <=stones.length; len++) {
            //从1开始
            for (int i = 1; i+len-1<=stones.length ; i++) {
                int j = i+len-1;//右端点 -1的原因是j已经包含在len里面了
                //拿走最左边/拿走最右边
                dp[i][j] = Math.max(sum[j]-sum[i]-dp[i+1][j],sum[j-1]-sum[i-1]-dp[i][j-1]);
                //Math.max表示求最好
                //拿走最左边i 最坏情况下是第一个人的收益sum[j]-sum[i] 减去第二个人最好情况dp[i+1][j]
                //拿走最右边同理
            }
        }
        return dp[1][stones.length];
    }
}