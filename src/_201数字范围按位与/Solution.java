package _201数字范围按位与;

/**
 201. 数字范围按位与
 难度
 中等
 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 示例 1:
 输入: [5,7]
 输出: 4
 示例 2:
 输入: [0,1]
 输出: 0
 */

//思路，寻找m，n公共前缀,位移
class Solution {
    public static int rangeBitwiseAnd(int m, int n) {
    int move=0;
    while(m<n)
    {
        m=m>>1;
        n=n>>1;
        move++;
    }
    return m<<move;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
    }
}