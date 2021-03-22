package _5603确定两个字符串是否接近;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 */

//只要出现都是相同字符，然后出现次数都相同就trie
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int str1[] = new int[26];
        int str2[] = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            set1.add(word1.charAt(i));
            str1[word1.charAt(i)-'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            set2.add(word2.charAt(i));
            str2[word2.charAt(i)-'a']++;
        }
        if(set1.size()!=set2.size())
            return false;
        for (Character character : set1) {
            if(!set2.contains(character))
            {
                return false;
            }
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < str1.length; i++) {
            if(str1[i]!=str2[i])
                return false;
        }
        return true;
    }
}