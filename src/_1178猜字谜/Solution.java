package _1178猜字谜;

import java.util.*;

/**
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 *
 * 	单词 word 中包含谜面 puzzle 的第一个字母。
 * 	单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 	例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
 *
 *
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//超时
class Solution {
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            TreeSet<Character> treeSet = new TreeSet<Character>();
            for (int j = 0; j < word.length(); j++) {
                treeSet.add(word.charAt(j));
            }
            StringBuilder sb = new StringBuilder();
            for (Character character : treeSet) {
                sb.append(character);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (String puzzle : puzzles) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < puzzle.length(); i++) {
                set.add(puzzle.charAt(i));
            }
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            int total = 0;
            char firstchar = puzzle.charAt(0);
            for (Map.Entry<String, Integer> entry : entries) {
                String key = entry.getKey();
                boolean flag = false;
                boolean flag2 = false;
                for (int i = 0; i < key.length(); i++) {
                    if(!set.contains(key.charAt(i)))
                    {
                        flag = true;
                        break;
                    }
                    if(firstchar==key.charAt(i))
                    {
                        flag2=true;
                    }
                }
                if(!flag&&flag2)
                {
                    total+=entry.getValue();
                }
            }
            list.add(total);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"apple","pleas","please"};
        String[] puzzles = new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};
        List<Integer> numOfValidWords = findNumOfValidWords(words, puzzles);
        for (Integer numOfValidWord : numOfValidWords) {
            System.out.println(numOfValidWord);
        }
    }
}