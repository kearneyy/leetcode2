package _567字符串的排列;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int[] charnum1 = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>len2)
            return false;
        for (int i = 0; i < len1; i++) {
            charnum1[s1.charAt(i)-'a']++;
        }
        int[] charnum2 = new int[26];
        for (int i = 0; i < len1; i++) {
            charnum2[s2.charAt(i)-'a']++;
        }
        int left = 0;
        int right = len1;
        for (; right < len2; right++) {
            boolean flag = false;
            for (int j = 0; j < 26; j++) {
                if(charnum1[j]!=charnum2[j])
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                charnum2[s2.charAt(left)-'a']--;
                left++;
                charnum2[s2.charAt(right)-'a']++;
            }
            else
            {
                return true;
            }
        }
        for (int j = 0; j < 26; j++) {
            if(charnum1[j]!=charnum2[j])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = checkInclusion("hello", "ooolleoooleh");
        System.out.println(b);
    }
}