package _316去除重复字母;

import java.util.*;

/**
 *
 *单调栈
 */
class Solution {
    public static String removeDuplicateLetters(String s) {
      boolean visit[] = new boolean[26];
      int last[] = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            last[chars[i]-'a']=i;
        }
       Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if(visit[chars[i]-'a'])
            {
                continue;
            }
            while (!stack.isEmpty()&&stack.peekLast()>chars[i]&&last[stack.peekLast()-'a']>i)
            {
                Character character = stack.removeLast();
                visit[character-'a']=false;
            }
            stack.addLast(chars[i]);
            visit[chars[i]-'a']=true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String bcbcaddabc = removeDuplicateLetters("ecbacba");
        System.out.println(bcbcaddabc);
    }
}