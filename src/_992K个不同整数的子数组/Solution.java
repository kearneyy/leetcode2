package _992K个不同整数的子数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 *
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 *
 * 返回 A 中好子数组的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 *
 * 示例 2：
 *
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//自己写的滑动窗口 过了一半以上用例
class Solution {
    public static int subarraysWithKDistinct(int[] A, int K) {
        List<List<Integer>> list = new ArrayList<>();
        int left = 0;
        int right  = K-1;
        int count = 0;
        int len = A.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            Integer num = map.getOrDefault(A[i], 0);
            num++;
            map.put(A[i],num);
        }
        boolean large = true;
        while (left<len-K+1)
        {
            if(large)
            {
                if(map.size()==K)
                {
                    count++;
                    add(list,left,right,A);
                    if(right<len-1)
                    {
                        right++;
                        Integer num = map.getOrDefault(A[right], 0);
                        num++;
                        map.put(A[right],num);
                    }
                    else
                    {
                        Integer leftnum = map.get(A[left]);
                        if(leftnum==1)
                        {
                            map.remove(A[left]);
                        }
                        else
                        {
                            map.put(A[left],leftnum-1);
                        }
                        left++;
                        large = false;
                    }
                }
                else if(map.size()>K)
                {
                    large = false;
                    Integer leftnum = map.get(A[left]);
                    if(leftnum==1)
                    {
                        map.remove(A[left]);
                    }
                    else
                    {
                        map.put(A[left],leftnum-1);
                    }
                    left++;
                    if(right-left+1==K)
                    {
                        large = true;
                    }
                }
                else
                {
                    if(right<len-1)
                    {
                        right++;
                        Integer num = map.getOrDefault(A[right], 0);
                        num++;
                        map.put(A[right],num);
                    }
                    else
                    {
                        break;
                    }
                }
            }
            else
            {
                if(map.size()==K)
                {
                    if(right-left+1==K)
                    {
                        large = true;
                    }
                    count++;
                    add(list,left,right,A);
                    if(right-left+1>K)
                    {
                        Integer rightnum = map.get(A[right]);
                        if(rightnum==1)
                        {
                            map.remove(A[right]);
                        }
                        else
                        {
                            map.put(A[right],rightnum-1);
                        }
                        right--;
                    }
                    else
                    {
                        large = true;
                        Integer leftnum = map.get(A[left]);
                        if(leftnum==1)
                        {
                            map.remove(A[left]);
                        }
                        else
                        {
                            map.put(A[left],leftnum-1);
                        }
                        left++;
                        if(right<len-1)
                        {
                            right++;
                            Integer num = map.getOrDefault(A[right], 0);
                            num++;
                            map.put(A[right],num);
                        }
                    }
                }
                else if (map.size()<K)
                {
                    large = true;
                    Integer leftnum = map.get(A[left]);
                    if(leftnum==1)
                    {
                        map.remove(A[left]);
                    }
                    else
                    {
                        map.put(A[left],leftnum-1);
                    }
                    left++;
                    if(right<len-1)
                    {
                        right++;
                        Integer num = map.getOrDefault(A[right], 0);
                        num++;
                        map.put(A[right],num);
                    }
                }
                else
                {
                    if(right-left+1>K)
                    {
                        Integer rightnum = map.get(A[right]);
                        if(rightnum==1)
                        {
                            map.remove(A[right]);
                        }
                        else
                        {
                            map.put(A[right],rightnum-1);
                        }
                        right--;
                    }
                    else
                    {
                        large = true;
                        Integer leftnum = map.get(A[left]);
                        if(leftnum==1)
                        {
                            map.remove(A[left]);
                        }
                        else
                        {
                            map.put(A[left],leftnum-1);
                        }
                        left++;
                        if(right<len)
                        {
                            right++;
                            Integer num = map.getOrDefault(A[right], 0);
                            num++;
                            map.put(A[right],num);
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void add(List<List<Integer>> lists,int left,int right,int[] A)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            list.add(A[i]);
        }
        lists.add(list);
    }

    public static void main(String[] args) {
        int i = subarraysWithKDistinct(new int[]{ 1,2,1,2,3,2,2}, 2);
        System.out.println(i);
    }
}
