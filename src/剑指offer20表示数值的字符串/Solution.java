package 剑指offer20表示数值的字符串;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 难度
 * 中等
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、
 * "5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、
 * "+-5"及"12e+5.4"都不是。
 */


/**
 * ‘.’出现正确情况：只出现一次，且在e的前面
 * ‘e’出现正确情况：只出现一次，且出现前有数字
 * ‘+’‘-’出现正确情况：只能在开头和e后一位
 * 首先不管哪种情况都必须要有数字，没有数字肯定不对，其次对于存在 e 的情况，
 * 接收到 e 时已经判断前面有数字了，并将 numFlag 重置，意味着当接收到 e 后，
 * 如果后面没有数字（没有将 numFlag 重新标记为真），那么也是不对的。
 * 评论区
 */
class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        //去掉首位空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
}