package _11盛最多水的容器;

/**
 * 11. 盛最多水的容器
 * 难度
 * 中等
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
class Solution {
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int max = 0;
        int minindex=0;
        while(left<right)
        {
            minindex=height[left]<=height[right]?left:right;
            max=Math.max((right-left)*height[minindex],max);
            if(left==minindex)
            {
                if(height[left]==height[right])
                {
                    right--;
                }
                left++;
            }
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        int max = maxArea(new int[]{});
        System.out.println(max);
    }
}
