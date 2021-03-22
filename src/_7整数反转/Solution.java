package _7整数反转;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
class Solution {
    public static int reverse(int x) {
        if (x==(int)(-Math.pow(2,32))||x == 0) {
            return 0;
        }
        int num = Math.abs(x);
        double res = 0;
        do {
            res *= 10;
            int remain = num % 10;
            res += remain;
            num/=10;
        } while (num!= 0);
        if (x > 0)
            return res>Math.pow(2,31)-1? 0:(int)res;
        else
            return res>Math.pow(2,31)? 0:(int)-res;
    }

}