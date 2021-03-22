package _941有效的山脉数组;

/**
 * 941. 有效的山脉数组
 * 难度
 * 简单
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */
class Solution {
    public static boolean validMountainArray(int[] A) {
        int i=0;
        while (i+1<A.length&&A[i+1]>A[i])
        {
            i++;
        }
        if(i==0||i==A.length-1)
            return false;
        while (i+1<A.length&&A[i+1]<A[i])
        {
            i++;
        }
        return i == A.length - 1;
    }

    public static void main(String[] args) {
        boolean b = validMountainArray(new int[]{});
        System.out.println(b);
    }
}
