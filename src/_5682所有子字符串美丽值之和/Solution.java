package _5682所有子字符串美丽值之和;

import java.util.Arrays;
import java.util.List;

/**
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 *
 *     比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 *
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 *
 * 示例 2：
 *
 * 输入：s = "aabcbaa"
 * 输出：17
 */

//滑动数组 不难
class Solution {
    public static int beautySum(String s) {
        int count = 0;
        int left = 0;
        int len =s.length();
        while (left<len)
        {
            int[] num = new int[26];
            int right = left;
            for (; right <len ; right++) {
                int max = -1;
                int min = Integer.MAX_VALUE;
                num[s.charAt(right)-'a']++;
                for (int i = 0; i < num.length; i++) {
                    if(num[i]>=max)
                    {
                        max=num[i];
                    }
                    if(num[i]<=min&&num[i]!=0)
                    {
                        min=num[i];
                    }
                }
                count+=max-min;
            }
            left++;
        }
        return count;
    }

    public static void main(String[] args) {
        int aabcb = beautySum("a");
        System.out.println(aabcb);
    }
}
