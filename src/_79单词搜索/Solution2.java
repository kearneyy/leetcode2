package _79单词搜索;

class Solution2 {
    private boolean flag = false;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        char first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==first)
                {
                    dfs(i,j,board,word,board.length,board[0].length,used,0);
                }
                if(flag)
                {
                    return flag;
                }
            }
        }
        return false;
    }

    private void dfs(int i, int j, char[][] board, String word, int row, int col,boolean[][] used,int index) {
        if(flag)
        {
            return;
        }
        if(j<0||i<0||i>=row||j>=col||used[i][j]||board[i][j]!=word.charAt(index))
        {
            return;
        }
        if(index==word.length()-1)
        {
            flag=true;
            return;
        }
        used[i][j]=true;
        dfs(i,j+1,board,word,row,col,used,index+1);
        dfs(i,j-1,board,word,row,col,used,index+1);
        dfs(i-1,j,board,word,row,col,used,index+1);
        dfs(i+1,j,board,word,row,col,used,index+1);
        used[i][j]=false;
    }
}