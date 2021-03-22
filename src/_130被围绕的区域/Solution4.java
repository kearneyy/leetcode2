package _130被围绕的区域;

//自己写的

/**
 * 0 从上来 1从左来 2从右来 3从下来
 * 对四个边框遍历，递归深度遍历记录所有0的位置
 * 官方题解思想比较好，走过的路就直接让他成为A
 * 如果遇到不是O就停止
 * 而自己的解法很繁琐，考虑到不能回头走，没有用到DFS走过标记的精髓，而是走了就不回头，拿了一个变量记录从哪里来
 */
class Solution4 {
    public static void solve(char[][] board) {
        int imax = board.length;
        if (imax==0)
            return;
        int jmax = board[0].length;
        if (imax==1||jmax==1)
            return;
        int[][] flags = new int[imax][jmax];
        for (int i = 0; i < imax; i++) {
            if(board[i][0]=='O')
            {

                flags[i][0]=1;
                check(i,0,1,board,flags);
            }
            if(board[i][jmax-1]=='O')
            {

                flags[i][jmax-1]=1;
                check(i,jmax-1,2,board,flags);
            }
        }
        for (int j = 0; j < jmax; j++) {
            if(board[0][j]=='O')
            {

                flags[0][j]=1;
                check(0,j,0,board,flags);
            }
            if(board[imax-1][j]=='O')
            {

                flags[imax-1][j]=1;
                check(imax-1,j,3,board,flags);
            }
        }
        for (int i = 1; i < imax-1; i++) {
            for (int j = 1; j < jmax-1; j++) {
                if(flags[i][j]!=1)
                {
                    board[i][j]='X';
                }
            }
        }
    }

    private static void moveup(int x,int y,int flag,char[][] board,int[][] flags)
    {
        if(x-1>=0&&board[x-1][y]=='O')
        {
            if(flags[x-1][y]!=1)
            {
                flags[x-1][y]=1;
                check(x-1,y,3,board,flags);
            }
        }
    }
    private static void movedwon(int x,int y,int flag,char[][] board,int[][] flags)
    {
        if(x+1<board.length&&board[x+1][y]=='O')
        {
            if(flags[x+1][y]!=1)
            {
                flags[x+1][y]=1;
                check(x+1,y,0,board,flags);
            }
        }
    }
    private static void moveleft(int x,int y,int flag,char[][] board,int[][] flags)
    {
        if(y-1>=0&&board[x][y-1]=='O')
        {
            if(flags[x][y-1]!=1)
            {
                flags[x][y-1]=1;
                check(x,y-1,2,board,flags);
            }
        }
    }
    private static void moveright(int x,int y,int flag,char[][] board,int[][] flags)
    {
        if(y+1<board[0].length&&board[x][y+1]=='O')
        {
            if(flags[x][y+1]!=1)
            {
                flags[x][y+1]=1;
                check(x,y+1,1,board,flags);
            }
        }
    }

    public static void check(int x,int y,int flag,char[][] board,int[][] flags){
        if (flag==0)
        {
            moveleft(x,y,flag,board,flags);
            moveright(x,y,flag,board,flags);
            movedwon(x,y,flag,board,flags);
        }
        if (flag==1)
        {
            moveup(x,y,flag,board,flags);
            moveright(x,y,flag,board,flags);
            movedwon(x,y,flag,board,flags);
        }
        if (flag==2)
        {
            moveleft(x,y,flag,board,flags);
            moveup(x,y,flag,board,flags);
            movedwon(x,y,flag,board,flags);
        }
        if (flag==3)
        {
            moveleft(x,y,flag,board,flags);
            moveright(x,y,flag,board,flags);
            moveup(x,y,flag,board,flags);
        }
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
        char[][] board = {{'O','O'},{'O','O'}};

        show(board);
        System.out.println();
        solve(board);
        show(board);
    }
}
