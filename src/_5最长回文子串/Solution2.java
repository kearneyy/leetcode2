package _5最长回文子串;

/**
 * 动态规划
 * 一个回文串 去掉头尾仍是回文 dp[i][j]==dp[i+1][j-1]
 * 当j-i<3 设置为true 填写二维表
 */

public class Solution2 {
    public static String longestPalindrome(String s) {
      int len = s.length();
      if(len<2)
          return s;
      boolean[][] dp = new boolean[len][len];
      char[] array = s.toCharArray();
      int maxlen=1;//记录长度
      int begin=0;//记录开始位置

      //对角线表示单个字符，初始化设置为true
      for(int i=0;i<len;i++)
      {
          dp[i][i]=true;
      }
      //由于i一定小于j，故只填右上方部分的表格，但是要注意填写的方向，这里从左到右，从上到下
      for(int j=1;j<len;j++)
      {
          for(int i=0;i<j;i++)
          {
              if(array[i]!=array[j])
              {
                  dp[i][j]=false;
              }
              else
              {
                  if(j-i<3)
                  {
                      dp[i][j]=true;
                  }
                  else
                  {
                      dp[i][j]=dp[i+1][j-1];
                  }
              }
              if(dp[i][j]&&j-i+1>maxlen)
              {
                  maxlen=j-i+1;
                  begin = i;
              }
          }

      }
      return s.substring(begin,begin+maxlen);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}

