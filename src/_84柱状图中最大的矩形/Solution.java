package _84柱状图中最大的矩形;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
class Solution {
    public static int largestRectangleArea(int[] heights) {
        int res = heights[0];
        for (int i = 1; i < heights.length; i++) {
            int width = heights[i];
            int area = width;
            for (int j = i - 1; j >= 0; j--) {
                width = Math.min(width, heights[j]);
                area = Math.max(area, width * (i - j + 1));
            }
            res = Math.max(res, area);
        }
        return res;
    }

    public static void main(String[] args) {
        int num[] = new int[]{2,1,5,6,2,3};
        int i = largestRectangleArea(num);
        System.out.println(i);
    }
}