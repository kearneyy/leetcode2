package _5681判断一个数字是否可以表示成三的幂的和;

import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.util.*;

/**
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 *
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 *
 * 示例 2：
 *
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 *
 * 示例 3：
 *
 * 输入：n = 21
 * 输出：false
 */

//sb了 回溯构造所有的数
class Solution {
   // static List<List<Integer>> lists =new ArrayList<>();
    public static boolean checkPowersOfThree(int n) {
       int[] nums = new int[]{1,3,9,27,81,243,729,2187,6561,19683,59049,177147,531441,1594323,4782969};
        Set<Integer> set = new HashSet<>();
        dfs(nums,set,0);
        return set.contains(n);
    }

    public static void dfs(int[] nums,Set<Integer> set,int begin){
        //lists.add(new ArrayList<>(list));
        int total = 0;
        for (; begin <nums.length ; begin++) {
            total +=nums[begin];
            set.add(total);
            dfs(nums,set,begin+1);
            total-=nums[begin];
        }
    }

    public static void main(String[] args) {
        boolean b = checkPowersOfThree(6378022);
        System.out.println(b);
//        for (List<Integer> list : lists) {
////            System.out.println(list);
////        }
    }
}
