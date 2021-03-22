package _17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 难度
 * 中等
 * 个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits==null||digits.length() == 0)
            return list;
        Map<Character,String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder sb = new StringBuilder();
        dfs(map,list,1,digits,sb);
        return list;
    }

    public static void dfs(Map<Character,String> map,List<String> list,int cur,String digits,StringBuilder sbtemp)
    {
        StringBuilder sb = new StringBuilder(sbtemp);
        if(cur==digits.length()+1)
        {
            list.add(sb.toString());
            return;
        }
        String chars = map.get(digits.charAt(cur - 1));
        for (int i = 0; i < chars.length(); i++) {
            sb.append(chars.charAt(i));
            dfs(map,list,cur+1,digits,sb);
            sb.deleteCharAt(cur-1);
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("");
        for (String s : list) {
            System.out.println(s);
        }
    }
}