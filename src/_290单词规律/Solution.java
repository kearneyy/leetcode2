package _290单词规律;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length!=pattern.length()) return false;
        Map<Character,String> map = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch =  pattern.charAt(i);
            if(!map.containsKey(ch))
            {
                if(!map2.containsKey(strs[i]))
                {
                    map.put(ch,strs[i]);
                    map2.put(strs[i],ch);
                }
                else
                {
                    return false;
                }

            }
            else
            {
                String str = map.get(ch);
                Character cha = map2.get(strs[i]);
                if(!strs[i].equals(str)||cha!=ch)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = wordPattern("abba", "dog cat cat dog");
        System.out.println(b);
    }
}