package 面试题58左旋转字符串;

/**
 * 面试题58 - II. 左旋转字符串
 * 难度
 * 简单
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数
 * 实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回
 * 左旋转两位得到的结果"cdefgab"。
 */
class Solution {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }

    public static void main(String[] args) {

        System.out.println(reverseLeftWords("abcdefg",2));
    }
}