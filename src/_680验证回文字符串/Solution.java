package _680验证回文字符串;

/**
 * 680. 验证回文字符串 Ⅱ
 * 难度
 * 简单
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 双指针
 */
class Solution {
    public static boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;

        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                break;
            }
            head++;
            tail--;
        }
        if (head >= tail)
            return true;
        boolean flag = true;
        int head_two = head;
        int tail_two = tail;
        if (s.charAt(head) == s.charAt(tail - 1)) {
            tail--;
        } else {
            head++;
        }
        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                break;
            }
            head++;
            tail--;
        }
        if (head >= tail)
            return true;
        head_two++;
        while (head_two < tail_two) {
            if (s.charAt(head_two) != s.charAt(tail_two)) {
                return false;
            }
            head_two++;
            tail_two--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }
}