package _842将数组拆分成斐波那契序列;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 	0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * 	F.length >= 3；
 * 	对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//自己写的错的
class Solution {
    public static List<Integer> splitIntoFibonacci(String S) {

        List<int[]> indexlist = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(S.charAt(0)=='0')
            return list;
        int nums[] = new int[]{0,-1};
        indexlist.add(nums);
        int total=0;
        for (int i = 0; i < S.length()/2; i++) {
            nums[0]++;
            nums[1]++;
            total=total*i+(S.charAt(i)-'0');
            list.add(total);
            if(dfs(indexlist,S,list,0))
            {
                return list;
            }
            list.remove(0);
        }
        return list;
    }

    //int[长度，最后的下标]
    public static boolean dfs(List<int[]> indexlist,String S,List<Integer> list,int index){
        int[] nums = indexlist.get(index);
        int num = list.get(index);
        int total=0;
        int count=1;
        if(S.charAt(nums[1]+1)=='0')
        {
            return false;
        }
        for (int i = nums[1]+1; i<S.length() ; i++) {
            if(S.length()-nums[1]-count<Math.min(nums[1],count))
            {
                return false;
            }

            total= total*count+S.charAt(i)-'0';
            count*=10;
            list.add(total);
            int next=total+num;
            String nextstr = String.valueOf(next);
            String realnextstr=S.substring(i+1,i+1+nextstr.length());
            if(realnextstr.equals(nextstr))
            {
                if(i==S.length()-1)
                {
                    return true;
                }
                int nextlist[] = new int[]{nextstr.length(),i+nextstr.length()-1};
                indexlist.add(nextlist);
                list.add(next);
                if(!dfs(indexlist,S,list,++index))
                {
                    nums[0]++;
                    nums[1]++;
                    return false;
                }
            }
            list.remove(index);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "123456579";
        List<Integer> list = splitIntoFibonacci(s);
        System.out.println(list);
    }
}
