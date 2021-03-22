package _132分割回文串II;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 *
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//再用昨天的递归会超时 要两遍动规Solution
class Solution {

    static int min = Integer.MAX_VALUE;
    static int count = 0;
    public static int minCut(String s) {
        int len = s.length();
        if(len==0)
            return 0;
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <=right;left++) {
                if(s.charAt(left)==s.charAt(right)&&(right-left<=2||dp[left+1][right-1]))
                {
                    dp[left][right]=true;
                }
            }
        }
        dfs(dp,0,len);
        return min-1;
    }

    public static void dfs(boolean[][] dp,int index,int len)
    {
        if(index==len)
        {
            min = Math.min(min,count);
            return;
        }
        for (int i = index; i < len ; i++) {
            if(dp[index][i])
            {
                count++;
                dfs(dp,i+1,len);
                count--;
            }
        }
    }

    public static void main(String[] args) {
        int aab = minCut("aab");
        System.out.println(aab);
    }
}