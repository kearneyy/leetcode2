package _557反转字符串中的单词III;

import java.util.StringTokenizer;

/**
 557. 反转字符串中的单词 III
 难度
 简单
 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 示例：
 输入："Let's take LeetCode contest"
 输出："s'teL ekat edoCteeL tsetnoc"
 */
//利用api
class Solution {
    public static String reverseWords(String s) {
        if(s==null||s.length()==0)
            return "";
        StringTokenizer st = new StringTokenizer(s," ");
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens())
        {
            StringBuilder sbtemp = new StringBuilder(st.nextToken());
            sb.append(sbtemp.reverse());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's     take LeetCode    contest"));
    }
}