package _392判断子序列;

/**
 * 392. 判断子序列
 * 难度
 * 简单
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 */
class Solution {
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        if(t.length()==0)
            return false;
        int i = 0;
        int j = 0;
        while(i<s.length()&&j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        return i >= s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
