package _97交错字符串;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 示例 1:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
//动态规划
class Solution {
    //    public static boolean isInterleave(String s1, String s2, String s3) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//
//        if(s3.length()!=len1+len2)
//        return false;
//        boolean[][] dp = new boolean[len1+1][len2+1];
//        dp[0][0] = true;
//        for(int i=1;i<=len1&& s1.charAt(i-1)==s3.charAt(i-1);i++)
//        {
//            dp[i][0]=true;
//        }
//        for(int j=1;j<=len2&& s2.charAt(j-1)==s3.charAt(j-1);j++)
//        {
//            dp[0][j]=true;
//        }
//        for (int i = 1; i<=len1; i++) {
//            for (int j = 1; j <=len2; j++) {
//                dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
//            }
//        }
//        return dp[len1][len2];
//    }
//滚动数组
    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (s3.length() != len1 + len2)
            return false;
        if(s1.equals(""))
        {
            return s2.equals(s3);
        }
        if(s2.equals(""))
        {
            return s1.equals(s3);
        }
        boolean[] dp = new boolean[len2 + 1];
        dp[0]= s1.charAt(0) == s3.charAt(0) || s2.charAt(0) == s3.charAt(0);
        for (int j = 1; j <= len2 && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[j] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len2];
    }

    public static void main(String[] args) {
        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";
        System.out.println(isInterleave(s1, s2, s3));

//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbbaccc";
//        System.out.println(isInterleave(s1,s2,s3));
    }
}