package _79单词搜索;

/**
 * 79. 单词搜索
 * 难度
 * 中等
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * dfs回溯，可以直接在dfs返回boolean
 * 或者在dfs里一有flag=true就返回
 */

class Solution{
    //    private static boolean flag = false;
    static boolean[][] used;
    public static boolean exist(char[][] board, String word) {
        if(board==null||board.length==0)
            return false;
        used= new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(i,j,board,word,board.length,board[0].length,0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, char[][] board, String word, int row, int col,int index) {
        if(j<0||i<0||i>=row||j>=col||used[i][j]||word.charAt(index) != board[i][j])
        {
            return false;
        }
        if(index==word.length()-1)
        {
            return true;
        }
        used[i][j]=true;
        if(dfs(i,j+1,board,word,row,col,index+1)||dfs(i,j-1,board,word,row,col,index+1)||dfs(i-1,j,board,word,row,col,index+1)||dfs(i+1,j,board,word,row,col,index+1))
            return true;
        used[i][j]=false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','F'}};
        boolean a = exist(board,"ABCB");
        System.out.println(a);
    }
}
