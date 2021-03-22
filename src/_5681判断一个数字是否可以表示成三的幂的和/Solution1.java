package _5681判断一个数字是否可以表示成三的幂的和;

import java.util.*;

class Solution1 {
    static int total;
    public static boolean checkPowersOfThree(int n) {
        int[] nums = new int[]{1,3,9,27,81,243,729,2187,6561,19683,59049,177147,531441,1594323,4782969};
        Set<Integer> set = new HashSet<>();
        dfs(nums,set,0);
        return set.contains(n);
    }

    public static void dfs(int[] nums,Set<Integer> set,int begin){
        for (; begin <nums.length ; begin++) {
          total+=nums[begin];
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