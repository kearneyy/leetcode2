package _5最长回文子串;

/**
 * 5. 最长回文子串
 * 难度
 * 中等
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 中心扩散解法
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int length = s.length();
        if(length<2)
            return s;
        int max=1;
        String res = s.substring(0,1);
        for(int i=0;i<length;i++)
        {
            String odd = Palindrome(s,i,i);
            String even = Palindrome(s,i,i+1);
            if(Math.max(odd.length(),even.length())>max)
            {
                max = Math.max(odd.length(),even.length());
                res = odd.length()>even.length()? odd:even;
            } 
        }
        return res;
    }

    public static String Palindrome(String s,int left,int right)
    {
        int i=left,j=right;
        while(i>=0&&j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i--;
                j++;
            }
            else
            {
                break;
            }
        }
        return s.substring(i+1,j);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
