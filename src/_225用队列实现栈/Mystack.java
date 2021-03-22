package _225用队列实现栈;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * 难度
 * 简单
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 */
//双队列https://leetcode-cn.com/problems/implement-stack-using-queues/solution/liang-ge-dui-lie-de-shi-xian-ji-bai-liao-10000-de-/
//思路：使用两个队列的轮流使用，始终保持一个队列为空。
//（1）push()方法没什么问题，直接添加在非空的队列中就好。
//（2）pop()方法在于将装载元素中的队列的前n-1都移到另外一个空队列中（利用size方法），最后一个元素直接取出返回。
//（3）top()方法和pop()方法基本思路一致，只是在前n-1个元素移动后，将最后一个元素赋值，然后在压入队列中去。
//（4）empty()方法直接判断两个队列是否都为空即可。
//注意：
//（1）队列的接口在Java中使用的是LinkedList<>()；
//（2）队列中的添加元素方法应当使用offer(), add()；
//（3）队列中的移除方法应当使用poll(), remove();
//
//作者：Heroin_XX
//链接：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/liang-ge-dui-lie-de-shi-xian-ji-bai-liao-10000-de-/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class MyStack {
    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty())
        {
            queue2.offer(x);
        }
        else
        {
            queue1.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.isEmpty()){
            while (queue2.size()>1)
            {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }else
        {
            while(queue1.size()>1)
            {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int top=0;
        if(queue1.isEmpty()){
            while (queue2.size()>1)
            {
                queue1.offer(queue2.poll());
            }
            top = queue2.poll();
            queue1.offer(top);
        }else
        {
            while(queue1.size()>1)
            {
                queue2.offer(queue1.poll());
            }
            top = queue1.poll();
            queue2.offer(top);

        }
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
