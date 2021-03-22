package _1438绝对差不超过限制的最长连续子数组;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//双端单调队列 快很多
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> up = new LinkedList<>();//递增队列确保right最大，最小值存在up里
        Deque<Integer> down = new LinkedList<>();//递减队列确保right最小，最大值存在down里
        int left = 0;
        int right = 0;
        int len = nums.length;
        int res = 0;
        while (right<len)
        {
            while (!up.isEmpty()&&up.peekLast()>nums[right])
            {
                up.pollLast();
            }
            up.addLast(nums[right]);
            while (!down.isEmpty()&&down.peekLast()<nums[right])
            {
                down.pollLast();
            }
            down.addLast(nums[right]);
            while (down.peekFirst()-up.peekFirst()>limit)
            {
                if(down.peekFirst()==nums[left])down.pollFirst();
                if(up.peekFirst()==nums[left])up.pollFirst();
                left++;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}