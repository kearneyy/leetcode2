package _130被围绕的区域;

//自己写的

/**
**自己方法再改进
 */
class Solution5 {
    public static void solve(char[][] board) {
        int imax = board.length;
        if (imax==0)
            return;
        int jmax = board[0].length;
        if (imax==1||jmax==1)
            return;
        for (int i = 0; i < imax; i++) {
            dfs(i,0,board);
            dfs(i,jmax-1,board);
        }
        for (int j = 0; j < jmax; j++) {
            if(board[0][j]=='O')
           dfs(0,j,board);
           dfs(imax-1,j,board);
        }
        for (int i = 0; i < imax; i++) {
            for (int j = 0; j < jmax; j++) {
                if(board[i][j]=='Z')
                {
                    board[i][j]='O';
                }
                else
                    board[i][j]='X';
            }
        }
    }


    public static void dfs(int x,int y,char[][] board){
        if(x<0||y<0||x>=board.length||y>=board[0].length||board[x][y]!='O')
            return;
        board[x][y]='Z';
        dfs(x-1,y,board);
        dfs(x+1,y,board);
        dfs(x,y-1,board);
        dfs(x,y+1,board);
    }

    public static void show(char[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = {{'X','O','X','O','O','O','O'},{'X','O','O','O','O','O','O'},{'X','O','O','O','O','X','O'},{'O','O','O','O','X','O','X'},{'O','X','O','O','O','O','O'},{'O','O','O','O','O','O','O'},{'O','X','O','O','O','O','O'}};

        show(board);
        System.out.println();
        solve(board);
        show(board);
    }
}
