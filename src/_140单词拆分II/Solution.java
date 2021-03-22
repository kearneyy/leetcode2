package _140单词拆分II;

import java.util.*;

class Solution {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean dp[]  =new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <i ; j++) {
                if(dp[j]&&set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        List<String> list = new ArrayList<>();
        if(dp[s.length()])
        {
            Deque<String> deque = new ArrayDeque<>();
            dfs(deque,s,list,set,dp,s.length());
            return list;

        }
        return list;
    }

    private static void dfs(Deque<String> deque, String s, List<String> list, Set<String> set, boolean[] dp, int length) {
        if(length==0)
        {
            list.add(String.join(" ",deque));
            return;
        }

        for (int i = length-1; i >=0; i--) {
            String suffix = s.substring(i,length);
            if(set.contains(suffix)&&dp[i])
            {
                deque.addFirst(suffix);
                dfs(deque,s,list,set,dp,i);
                deque.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        list.add("leet");
        list.add("code");
        List<String> list1 = wordBreak("leetcode", list);
        System.out.println(list1);
    }
}
