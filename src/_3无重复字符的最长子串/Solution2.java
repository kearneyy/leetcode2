package _3无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 难度
 * 中等
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

//改进，数组不再保存boolean值，而是保存坐标
class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
        int len=s.length();
        while(left<len&&right<len) {//向右移动 键值对存的是上一次出现字符的位置
            char c =s.charAt(right);
            if(map.containsKey(c)&&(map.get(c)>=left))//如果出现了上一次字符，况且位置比左边坐标大，就把左边移到left+1
            {
                left=map.get(c)+1;
            }
            map.put(c,right);
            right++;
            max=Math.max(max,right-left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
