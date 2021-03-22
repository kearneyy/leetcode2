package _127单词接龙;

import java.util.*;

/**
 * 127. 单词接龙
 * 难度
 * 中等
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */


public class Solution {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size()==0)
            return 0;
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        Set<String> check = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int deep=1;
        while (queue.size()!=0)
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if(changeWord(poll,queue,set,endWord,check))
                {
                    return deep+1;
                }
            }
            deep++;
        }
        return 0;
    }

    public static boolean changeWord(String poll, Queue<String> queue, Set<String> set, String endWord, Set<String> check){
        char[] arr = poll.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if(c==ch)
                    continue;
                arr[i] =  c;
                String str  = String.valueOf(arr);
                if(set.contains(str))
                {
                    if(endWord.equals(str))
                        return true;
                    if(!check.contains(str))
                    {
                        queue.add(str);
                        check.add(str);
                    }
                }
            }
            arr[i]=ch;
        }
        return false;
    }

    public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("hot");
            list.add("dot");
            list.add("dog");
            list.add("lot");
            list.add("log");
            list.add("cog");
        int i = ladderLength("hit", "cog", list);
        System.out.println(i);
    }

}