package _529扫雷游戏;

//代码简化
class Solution2 {
    int[] dirx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] diry = {1, 0, 1, -1, -1, 1, -1, 0};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int[] num = check(board, x, y);
        if (num[1] != 0) {
            board[x][y] = (char) (num[1] + '0');
            return board;
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                dfs(board, x + dirx[i], y + diry[i]);
            }
            return board;
        }
    }

    //num[0]是周围B个数,num[1]是周围M个数
    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E')
            return;
        int[] num = check(board, x, y);
        if (num[0] == 0)
            return;
        if (num[1] != 0) {
            board[x][y] = (char) (num[1] + '0');
            for (int i = 0; i < 8; i++) {
                dfs(board, x + dirx[i], y + diry[i]);
            }
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                dfs(board, x + dirx[i], y + diry[i]);
            }
        }
    }


    //检查周围M和B的数量
    private int[] check(char[][] board, int x, int y) {
        int countB = 0;
        int countM = 0;
        for (int i = 0; i < 8; i++) {
            if (x + dirx[i] >= 0 && x + dirx[i] < board.length && y + diry[i] >= 0 && y + diry[i] < board[0].length) {
                if (board[x + dirx[i]][y + diry[i]] == 'M') {
                    countM++;
                }
                if (board[x + dirx[i]][y + diry[i]] == 'B') {
                    countB++;
                }
            }
        }
        return new int[]{countB, countM};
    }
}


