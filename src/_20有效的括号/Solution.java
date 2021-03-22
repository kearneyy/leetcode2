package _20有效的括号;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 难度
 * 简单
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
class Solution {
    public static boolean isValid(String s) {
        if (s.length()==0||s==null)
            return true;
        if(s.charAt(0)=='}'||s.charAt(0)==']'||s.charAt(0)==')')
            return false;
        Stack<Character> stack = new Stack<Character>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='{'||c=='['||c=='(')
            {
                stack.push(c);
            }
            if(c=='}'||c==']'||c==')')
            {
                if(!stack.isEmpty())
                {
                    char pop = stack.pop();
                    if((c == '}' && pop == '{')||(c==')'&&pop=='(')||(c==']'&&pop=='['))
                    {
                        continue;
                    }
                }

                    flag=false;
            }
        }
        if(stack.isEmpty())
        return flag;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(]}"));
    }
}