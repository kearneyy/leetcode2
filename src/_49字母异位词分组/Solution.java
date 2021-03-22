package _49字母异位词分组;

import java.util.*;

/**\
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//自己写的错的 题目理解错了 要出现次数一模一样
class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<Integer,List<String>> map = new HashMap<>();
        Set<Character> set =new HashSet<>();
        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }
            int total = 0;
            for (Character character : set) {
                total+=character-' ';
            }
            if(map.containsKey(total))
            {
                List<String> list = map.get(total);
                if(list.get(0).length()!=0)
                {
                    if(set.contains(list.get(0).charAt(0)))
                    {
                        list.add(str);
                        map.put(total,list);
                    }
                    else {
                        int num = getMin(str);
                        if(map.containsKey(total-num*num))
                        {
                            List<String> list1 = map.get(total - num * num);
                            list1.add(str);
                            map.put(total-num*num,list1);
                        }
                        else
                        {
                            List<String> list1 = new ArrayList<>();
                            list1.add(str);
                            map.put(total-num*num,list1);
                        }
                    }
                }
                else
                {
                    list.add(str);
                    map.put(total,list);
                }
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(total,list);
            }
            set.clear();
        }
        Set<Map.Entry<Integer, List<String>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<String>> entry : entries) {
            lists.add(entry.getValue());
        }
        return lists;
    }

    public  static int getMin(String s)
    {
        int minindex=0;
        int min=27;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)-'a'<min)
            {
                minindex=i;
                min=s.charAt(i)-'a';
            }
        }
        return s.charAt(minindex)-'a'-' ';
    }

    public static void main(String[] args) {
        String str[]  = {"",""};
        List<List<String>> lists = groupAnagrams(str);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
