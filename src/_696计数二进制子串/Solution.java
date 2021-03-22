package _696计数二进制子串;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * <p>
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */

/**
 * 思想：从头开始遍历，记录0的数量假设有n个 开始记录1的数量 如果数量m<=n，那么有m种，如果数量大于n，就有n种，
 * 然后从n+m开始继续搜索下一个数，此时把m赋值给n
 */
//       l   m
//   l n n m m
//   0 0 1 1 0 0 1 1
//   l n n m
//   0 0 1 0 0 1 0
class Solution {
    public static int countBinarySubstrings(String s) {
        int total = 0;//记录总数
        int m = 0;
        int l = 0;//记录当前指针
        int j;
        int i = 1; //i用于记录第一个数的数量
        int len = s.length();
        char first = s.charAt(0);
        while (i < len && first == s.charAt(i)) {
            i++;
        }
        l = i;
        while (l < len) {
            first = s.charAt(l - 1);
            m = l+1;
            j = 1;//j用于记录第二个数的数量
            //&&具有短路功能
            while (m < len && first != s.charAt(m)) {
                j++;
                m++;
            }
            total += Math.min(i, j);
            i = j;
            l = m;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("11111"));
    }
}