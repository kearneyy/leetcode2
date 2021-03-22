package _1370上升下降字符串;

import javax.imageio.stream.ImageInputStream;

/**
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 *
 * 	从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 	从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 	重复步骤 2 ，直到你没法从 s 中选择字符。
 * 	从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 	从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 	重复步骤 5 ，直到你没法从 s 中选择字符。
 * 	重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 *
 *
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"

 * 示例 2：
 *
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出："cdelotee"
 * 示例 4：
 * 输入：s = "ggggggg"
 * 输出："ggggggg"
 * 示例 5：
 * 输入：s = "spo"
 * 输出："ops"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//一开始看错题意了 sb题思路有问题
class Solution {
    public static String sortString(String s) {
        int nums[]= new int[26];
        for (int i = 0; i <s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int count=0;
        int beginindex=0;
        int lastindex=25;
        while (count<=s.length())
        {
            int tempj1=beginindex;

            for (int i = 0; i < 26; i++) {
               int j = tempj1;

                for (; j < 26; j++) {
                    if(nums[j]!=0)
                    {
                        sb.append((char)('a'+j));
                        nums[j]--;
                        count++;
                        tempj1=j+1;
                        break;
                    }

                }
                if(j==26)
                {
                    break;
                }

                if(count>=s.length())
                {
                    break;
                }

            }
            if(count>=s.length())
            {
                break;
            }
            int tempj2=lastindex;
            for (int i = 0; i < 26; i++) {
                int j = tempj2;
                for (; j >=0; j--) {
                    if(nums[j]!=0)
                    {
                        sb.append((char)('a'+j));
                        nums[j]--;
                        count++;
                        tempj2=j-1;
                        break;
                    }
                }
                if(count>=s.length())
                {
                    break;
                }
                if(j==-1)
                {
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String aaaabbbbcccc = sortString("ggggggg");
        System.out.println(aaaabbbbcccc);
    }
}
