package _3无重复字符的最长子串;

/**
 * 3. 无重复字符的最长子串
 * 难度
 * 中等
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

//双指针，一个left一个right
    //滑动窗口
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        boolean[] chars = new boolean[128];
        int left=0;
        int right=0;
        int max=0;
        int len=s.length();
        while(left<len&&right<len) {//向右移动
            char c =s.charAt(right);
            if(chars[(int)c]==false)//如果右边所指的字符在窗口中没有，在数组中将状态改为true，表示字符存在
            {
                chars[(int)c]=true;
                right++;
            }
            else//如果右边这个字符在数组中为true，即在窗口中有了，那么移动左边的指针，一直移到对应右边指针所指的字符下一个
            {
                while(s.charAt(left)!=c)
                {
                    chars[(int)s.charAt(left)]=false;
                    left++;
                }
                left++;
                right++;
            }
            max=Math.max(max,right-left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asdvs"));
    }
}
