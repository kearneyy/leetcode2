package _763划分字母区间;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> lists = new ArrayList<Integer>();
        if(S==null||S.length()==0)
            return lists;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = S.length()-1; i >=0; i--) {
            if(!map.containsKey(S.charAt(i)))
            {
                map.put(S.charAt(i),i);
            }
        }
        int[] nums = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            nums[i]=map.get(S.charAt(i));
        }
        int max=0;
        int begin=0;
        while(begin<S.length())
        {
            max=nums[begin];
            int index=begin;
            while (true)
            {
                if(nums[index]>max)
                {
                    max=nums[index];
                }
                if(max==index)//终止条件，当max和下标相等
                    break;
                index++;
            }
            lists.add(index-begin+1);
            begin=index+1;
        }
        return lists;
    }

    public static void main(String[] args) {
        List<Integer> list  = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(list);
    }
}