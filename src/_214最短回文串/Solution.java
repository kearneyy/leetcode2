package _214最短回文串;

/**
 * 214. 最短回文串
 * 难度
 * 困难
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * 示例 1:
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 * 输入: "abcd"
 * 输出: "dcbabcd"
 */


/**
 * i left ritht
 * 0  0     0
 * 1  0     1
 * 2  1     1
 * 3  1     2
 * 4  2     2
 * 5  2     3
 * aacecaaa
 */


//思路 找出最长回文子串 然后再补
    //面向测试用例编程
class Solution {
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 0)
            return "";
        int max = 0;
        int indexleft = 0;
        int indexright = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i / 2;
            int right = left + i % 2;
            int len = 0;
            while (left < s.length() && right < s.length()) {
                if (left >= 0 && s.charAt(left) == s.charAt(right)) {
                    len++;
                    left--;
                    right++;
                } else
                    break;
            }
            if (len > max && len > 1 && left < 0) {
                max = len;
                indexleft = left;
                indexright = right;
            }
        }
        StringBuilder sb = null;
        if (indexleft == -1) {
            String rightstr = s.substring(indexright);
            String leftstr = s.substring(indexleft+1, indexright);
//            if(s.charAt(0)==s.charAt(s.length()-1))
//            {
//                leftstr=s.substring(indexleft+1, indexright-1);
//            }
            if (rightstr.length()>1&&rightstr.charAt(0)==rightstr.charAt(rightstr.length()-1)&&rightstr.charAt(1)!=rightstr.charAt(rightstr.length()-2))
            sb = new StringBuilder(rightstr.substring(1));
            else
                sb = new StringBuilder(rightstr);
            sb.reverse();
            sb.append(leftstr);
            sb.append(rightstr);
        } else {
            String rightstr = null;
            if (s.length()>2&&s.charAt(0)==s.charAt(1)) {
                rightstr = s.substring(2);
            } else {
                rightstr = s.substring(1);
            }
            sb = new StringBuilder(rightstr);
            sb.reverse();
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("a"));
    }
}
