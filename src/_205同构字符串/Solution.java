package _205同构字符串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        char[] charss = s.toCharArray();
        char[] charst = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(charss[i]))
            {
                if(map.get(charss[i])!=charst[i])
                    return false;
            }
            else
            {
                map.put(charss[i],charst[i]);
            }
        }
        boolean ascii[] = new boolean[128];
        Iterator<Map.Entry<Character, Character>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Character, Character> next = iterator.next();
            if(ascii[next.getValue()-'0'])
            {
                return false;
            }
            else{
                ascii[next.getValue()-'0']=true;
            }
        }
        return true;
    }
}