package _51N皇后;

import java.util.*;

/**
 * 51. N 皇后
 * 难度
 * 困难
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例：
 * 输入：4
 * 输出：[
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
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */


//dfs,参考https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/
class Solution {
   static private boolean[] col;
   static private boolean[] main;
   static private boolean[] sub;
   static private List<List<String>> res;

    public static List<List<String>> solveNQueens(int n)
    {
        res = new ArrayList<>();
        if(n==0)
            return res;
        col=new boolean[n];
        main=new boolean[2*n-1];
        sub=new boolean[2*n-1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0,path,n);
        return res;
    }

    private static void dfs(int count, Deque<Integer> path,int n)
    {
        if(count==n)
        {
            List<String> board = convert2board(path,n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!col[i]&&!main[count-i+n-1]&&!sub[count+i])//count-i是定值，但下标不从0开始
            {
                col[i]=true;
                main[count-i+n-1]=true;
                sub[count+i]=true;
                path.add(i);
                dfs(count+1,path,n);
                col[i]=false;
                main[count-i+n-1]=false;
                sub[count+i]=false;
                path.removeLast();
            }
        }
        
    }

    private static List<String> convert2board(Deque<Integer> path,int n){
        List<String> board =new ArrayList<>();
        for (Integer integer : path) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i <n; i++) {
                if(i == integer) {
                    row.append('Q');
                }
                else
                    row.append('.');
            }
            board.add(row.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}