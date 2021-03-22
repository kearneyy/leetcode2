package _155最小栈;

import java.util.Stack;


/**155. 最小栈
 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 用一个辅助栈
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int x) {
        if(!stack.isEmpty())
        {
            if(x<=minstack.peek())
            {
                minstack.push(x);
            }
            stack.push(x);
        }
        else
        {
            minstack.push(x);
            stack.push(x);
        }
    }

    public void pop() {
        int num = stack.pop();
        if(num==minstack.peek())
        {
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */