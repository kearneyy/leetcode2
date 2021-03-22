package _395至少有K个重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 *
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//分治法，对少于k次的字母切割
class Solution {
    public int longestSubstring(String s, int k) {
       int n = s.length();
       return dfs(s,0,n-1,k);
    }

    public int dfs(String s,int l,int r,int k)
    {
        int cnt[] = new int[26];
        for (int i = l; i <= r ; i++) {
            cnt[s.charAt(i)-'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if(cnt[i]!=0&&cnt[i]<k)
            {
                split = (char)(i+'a');
                break;
            }
        }
        if(split==0)
        {
            return r-l+1;
        }
        int i = l;
        int ret = 0;
        while (i<=r)
        {
            while (i<=r&&s.charAt(i)==split)
            {
                i++;
            }
            if(i>r)
            {
                break;
            }
            int begin = i;
            while (i<=r&&s.charAt(i)!=split)
            {
                i++;
            }
            int len = dfs(s,begin,i-1,k);
            ret = Math.max(ret,len);
        }
        return ret;
    }
}
