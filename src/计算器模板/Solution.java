package 计算器模板;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


//https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484903&idx=1&sn=184beaad36a71c9a8dd93c41a8ba74ac&chksm=9bd7fbefaca072f9beccff92a715d92ee90f46c297277eec10c322bc5ccd053460da6afb76c2&scene=21#wechat_redirect
//通用计算器模板
class Solution {
    public static int calculate(String s) {
        Deque<Character> q=new LinkedList<>();
        for(char c:s.toCharArray()){
            q.offer(c);
        }
        return dfs(q);

    }
    public static int dfs(Deque<Character> q){
        Stack<Integer> stack=new Stack<>();

        // 当前运算符的前一个运算符
        char op='+';
        // op前面的数
        int num=0;
        int res=0;
        while(!q.isEmpty()){
            char c=q.poll();
            // c是数字就更新数字
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }

            // 左括号就进入递归
            if(c=='('){
                num=dfs(q);
            }

            // c是运算符
            if(!Character.isDigit(c)&&c!=' '||q.isEmpty()){
                if(op=='+'){
                    stack.push(num);
                }
                else if(op=='-'){
                    stack.push(-num);
                }
                else if(op=='*'){
                    stack.push(stack.pop()*num);
                }
                else if(op=='/'){
                    stack.push(stack.pop()/num);
                }

                num=0;
                op=c;

            }
            // 是右括号就退出循环 直接返回结果
            if(c==')'){
                break;
            }

        }

        //System.out.println(stack.toString());
        for(int i:stack){
            res+=i;
        }
        return res;

    }

    public static void main(String[] args) {
        int calculate = calculate("15(5)");
        System.out.println(calculate);
    }
}