package _5697检查二进制字符串字段;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "110"
 * 输出：true
 */
class Solution {
    public boolean checkOnesSegment(String s) {
        int index = 0;
        if(s.charAt(0)=='0')
        {
            return false;
        }
        while (index<s.length()&&s.charAt(index) == '1') {
            index++;
        }
        while (index<s.length()&&s.charAt(index) == '0') {
            index++;
        }
        return index==s.length();
    }
}
