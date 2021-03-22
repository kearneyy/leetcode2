package _459重复的子字符串;

/**
 * 459. 重复的子字符串
 * 难度
 * 简单
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            int time = 0;
            if (len % i == 0) {
                time = len / i;
                StringBuilder sb = new StringBuilder(s.substring(0, i));
                StringBuilder sb2 = new StringBuilder(sb);
                for (int j = 1; j <= time - 1; j++) {
                    sb.append(sb2);
                    if (!sb.toString().equals(s.substring(0, sb2.length() * (j + 1)))) {
                        break;
                    }
                    if (j == time - 1)
                        return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abac"));
    }
}
