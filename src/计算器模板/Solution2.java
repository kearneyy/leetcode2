package 计算器模板;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution2 {
    public static int calculate(String s) {
      Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }
        return dfs(deque);
    }

    private static int dfs(Deque<Character> deque) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int num = 0;
        char sign = '+';
        while (!deque.isEmpty())
        {
            Character character = deque.pollFirst();
            if(Character.isDigit(character))
            {
                num=num*10+(character-'0');
            }
            if(character=='(')
            {
                num = dfs(deque);
            }
            if(!Character.isDigit(character)&&character!=' '||deque.isEmpty())
            {
                if(sign=='+')
                {
                    stack.addLast(num);
                }
                else if(sign=='-')
                {
                    stack.addLast(-num);
                }
                else if(sign=='*')
                {
                    stack.addLast(stack.pollLast()*num);
                }
                else if(sign=='/')
                {
                    stack.addLast(stack.pollLast()/num);
                }
                sign = character;
                num = 0;
            }
            if(character==')')
                break;
        }
        int res = 0;
        for (Integer integer : stack) {
            res+=integer;
        }
        return res;
    }

    public static void main(String[] args) {
        int calculate = calculate("1+1");
        System.out.println(calculate);
    }
}
