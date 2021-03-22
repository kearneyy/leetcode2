package _131分割回文串;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 131. 分割回文串
 * <p>
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
class Solution {
    public static List<List<String>> partition(String s) {
       int len  = s.length();
       List<List<String>> lists = new ArrayList<>();
       if(len==0)return lists;
       //dp[i][j]代表s的i到j是回文串 先动态规划处理s
       boolean[][] dp = new boolean[len][len];
        //i是左边索引 j是右边索引
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <=j; i++) {
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||dp[i+1][j-1]))
                {
                    dp[i][j]=true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        dfs(s,dp,0,len,stack,lists);
       return lists;
    }

    public static void dfs(String s, boolean[][] dp, int index, int len, Deque<String> stack, List<List<String>> lists){
        if(index==len)
        {
            lists.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i <len ; i++) {
            if(dp[index][i])
            {
                stack.addLast(s.substring(index,i+1));
                dfs(s,dp,i+1,len,stack,lists);
                stack.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> aab = partition("aab");
        for (List<String> list : aab) {
            System.out.println(list);
        }
    }
}