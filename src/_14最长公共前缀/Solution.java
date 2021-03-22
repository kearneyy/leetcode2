package _14最长公共前缀;

/**
 * 14. 最长公共前缀
 * 难度
 * 简单
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index=0;
        while(true)
        {
            boolean flag=true;
            char c;
            if(index<strs[0].length())
            {
                c = strs[0].charAt(index);
            }
            else
            {
                break;
            }
            for (int i = 1; i <strs.length ; i++) {
                if(index>=strs[i].length()||strs[i].charAt(index)!=c)
                {
                    flag=false;
                    break;
                }
            }
            index++;
            if(flag)
            {
                sb.append(c);
            }
            else
            {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"",""};
        String str =longestCommonPrefix(strs);
        System.out.println(str);
    }
}