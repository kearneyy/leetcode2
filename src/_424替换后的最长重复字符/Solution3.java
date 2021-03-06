package _424替换后的最长重复字符;

/**
 * 424. 替换后的最长重复字符
 * 难度
 * 中等
 *
 * 243
 *
 *
 *
 *
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 *
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 */

//快了很多 改用数组
public class Solution3 {
    public static int characterReplacement(String s, int k) {
        if(s.length()+1<k)
            return s.length();
        char[] schar = s.toCharArray();
        int[] chars = new int[26];
        int left = 0;
        int right = 0;
        int maxvalue = 0;
        for (; right <s.length() ; right++) {
            chars[schar[right] - 'A']++;
            maxvalue = Math.max(maxvalue,chars[schar[right]- 'A']);
            if(right-left+1>maxvalue+k)
            {
                chars[schar[left]-'A']--;
                left++;
            }
        }
        return right==s.length()?right-left:right-left+1;
    }

    public static void main(String[] args) {
        int aaaa = characterReplacement("AABABBA", 1);
        System.out.println(aaaa);
    }
}