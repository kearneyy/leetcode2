package _387字符串中的第一个唯一字符;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//自己写的很麻烦
class Solution2 {
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map  = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer num = map.getOrDefault(s.charAt(i), 0);
            num++;
            map.put(s.charAt(i),num);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int loveleetcode = firstUniqChar("dddccdbba"
        );
        System.out.println(loveleetcode);
    }
}