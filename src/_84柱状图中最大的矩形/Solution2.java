package _84柱状图中最大的矩形;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *单调栈 用哨兵放在最前面 快很多
 */
public class Solution2 {
    public static int largestRectangleArea(int[] heights) {
       int len = heights.length;
       if(len==0)
           return 0;
       if(len==1)
           return heights[0];
       int res =  0;
       int newheight[] = new int[len+2];
        for (int i = 0; i <len ; i++) {
            newheight[i+1]=heights[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        len+=2;
        heights=newheight;
        for (int i = 1; i <len ; i++) {
            while (heights[i]<heights[stack.peekLast()])
            {
                int high = heights[stack.pollLast()];
                int width = i-stack.peekLast()-1;
                res = Math.max(res,high*width);
            }
            stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
         int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {1, 1};
        int res = largestRectangleArea(heights);
        System.out.println(res);
    }

}
