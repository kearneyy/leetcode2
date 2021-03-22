package _150逆波兰表达式求值;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 难度
 * 中等
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char c = token.charAt(0);
            boolean flag = token.length() == 1;
            if(c=='+'&&flag)
            {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop1+pop2);
            }
            else if(c=='-'&&flag)
            {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2-pop1);
            }
            else if(c=='*'&&flag)
            {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop1*pop2);
            }
            else if(c=='/'&&flag){
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                stack.push(pop2/pop1);
            }
            else
            {
                int num = Integer.parseInt(token);
               stack.push(num);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] strs  = new String[]{"-4","13","5","/","+"};
        int i = evalRPN(strs);
        System.out.println(i);
    }
}