package _5602将x减到0的最小操作数;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * 示例 1：
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 */

//自己写的回溯，只通过三十个用例
class Solution {
    static int count=0;
    static boolean flag = false;
    public static int minOperations(int[] nums, int x) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            deque.add(num);
        }
        dfs(deque,x);
        return flag?count:-1;
    }

    public static void dfs(Deque<Integer> deque, int x){
        if(x<0||deque.size()<=0)
        {
            return;
        }
        int first = deque.getFirst();
        int last = deque.getLast();
        if(x==first||x==last)
        {
            count++;
            flag=true;
            return;
        }
        if(first>=last&&first<x)
        {
            deque.removeFirst();
            count++;
            dfs(deque,x-first);
            if(flag)
                return;
            count--;
            deque.addFirst(first);
        }
        else if(last<x)
        {
            deque.removeLast();
            count++;
            dfs(deque,x-last);
            if(flag)
                return;
            count--;
            deque.addLast(last);
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,1};
        int i = minOperations(nums, 3);
        System.out.println(i);
    }
}