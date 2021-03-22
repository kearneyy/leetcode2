package _989数组形式的整数加法;


import java.util.ArrayList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 */
class Solution {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        String strK = String.valueOf(K);
        int length = Math.max(A.length+1,strK.length()+1);
        int nums[] = new int[length];
        int indexA = A.length-1;
        int indexK = strK.length()-1;
        int jinwei = 0;
        for (int i = length-1; i >=0; i--) {
            int num = jinwei;
            num+=indexA>=0?A[indexA]:0;
            num+=indexK>=0?strK.charAt(indexK)-'0':0;
            if(num>9)
            {
                num-=10;
                jinwei=1;
            }
            else
            {
                jinwei=0;
            }
            nums[i]=num;
            indexA--;
            indexK--;
        }
        if(nums[0]!=0)
        {
            list.add(nums[0]);
        }
        for (int i = 1; i <nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,0};
        List<Integer> list = addToArrayForm(nums, 34);
        System.out.println(list);
    }
}
