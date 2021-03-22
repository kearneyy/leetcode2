package _1024视频拼接;

import java.util.Arrays;

//动态规划,效率比贪心低
class Solution2 {
    public static int videoStitching(int[][] clips, int T) {
        int dp[] = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for (int i = 1; i <T+1 ; i++) {
            for (int[] clip : clips) {
                if(clip[0]<i&&clip[1]>=i)
                {
                    dp[i]=Math.min(dp[i],dp[clip[0]]+1);
                }
            }
        }
        return dp[T]==Integer.MAX_VALUE-1? -1:dp[T];

    }

    public static void main(String[] args) {
        int[][] clips = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int[][] clips = new int[][]{{0,4},{2,8}};
        int i = videoStitching(clips, 5);
        System.out.println(i);
    }
}
