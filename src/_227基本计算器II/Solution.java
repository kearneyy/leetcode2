package _227基本计算器II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 *
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 *
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//通用计算器写法
class Solution {
    public static int calculate(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int num  = 0;
        char sign = '+';
        int index = 0;
        while (index<s.length())
        {

            char c = s.charAt(index);
            index++;
            if(Character.isDigit(c))
            {
                num=num*10+(c-'0');
            }
            if(!Character.isDigit(c)&&c!=' '||index==s.length())
            {
                if(sign=='+')
                {
                    deque.addLast(num);
                }
                else if(sign=='-')
                {
                    deque.addLast(-num);
                }
                else if(sign=='*')
                {
                    deque.addLast(deque.pollLast()*num);
                }
                else if(sign=='/')
                {
                    deque.addLast(deque.pollLast()/num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        for (Integer integer : deque) {
            res+=integer;
        }
        return res;
    }

    public static void main(String[] args) {
        int calculate = calculate(" 3+5 / 2 ");
        System.out.println(calculate);
    }
}