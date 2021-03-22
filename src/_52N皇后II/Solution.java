package _52N皇后II;

/**
 * 52. N皇后 II
 * 难度
 * 困难
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
class Solution {
    static boolean[] cols;
    static boolean[] main;
    static boolean[] sub;
    static int total=0;
    public static int totalNQueens(int n) {
        cols = new boolean[n];
        main = new boolean[2*n-1];
        sub = new boolean[2*n-1];
        dfs(0,n);
        return total;
    }

    private static void dfs(int count,int n){
        if(count==n)
        {
            total++;
        }
        else
        {
            //找对角线下标的规律 i-j每一对角线为定值
            for (int i = 0; i < n; i++) {
                if(!cols[i]&&!main[count-i+n-1]&&!sub[i+count])
                {
                    cols[i]=true;
                    main[count-i+n-1]=true;
                    sub[i+count]=true;
                    dfs(count+1,n);
                    cols[i]=false;
                    main[count-i+n-1]=false;
                    sub[i+count]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(0));
    }
}