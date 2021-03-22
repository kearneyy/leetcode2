package _1002查找常用字符;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 * 难度
 * 简单
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
class Solution {
    public static List<String> commonChars(String[] A) {
        int[][] nums  = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                nums[i][c-'a']++;
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int number = getMinnum(nums,i);
            for (int j = 0; j < number; j++) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }

    public static int getMinnum(int[][] nums,int index)
    {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i][index]<min)
            {
                min=nums[i][index];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<String> list = commonChars(new String[]{"cool", "lock", "cook"});
        for (String s : list) {
            System.out.println(s);
        }
    }
}