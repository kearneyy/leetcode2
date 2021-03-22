package _529扫雷游戏;

/**
 * 529. 扫雷游戏
 * 难度
 * 中等
 * 让我们一起来玩扫雷游戏！
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * <p>
 * 示例 1：
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * 解释:
 * <p>
 * 示例 2：
 * 输入:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 * <p>
 * Click : [1,2]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 */

class Solution {
    public static char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int[] num = check(board, x, y);
        if (num[1] != 0) {
            board[x][y] = (char) (num[1] + 48);
            dfsgo(board, x, y);
            return board;
        } else {
            board[x][y] = 'B';
            dfsgo(board, x, y);
            return board;
        }
    }

    private static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E')
            return;
        int[] num = check(board, x, y);
        if (num[0] == 0)
            return;
        if (num[1] != 0) {
            board[x][y] = (char) (num[1] + '0');
            dfsgo(board, x, y);
        } else {
            board[x][y] = 'B';
            dfsgo(board, x, y);
        }
    }

    private static void dfsgo(char[][] board, int x, int y) {
        dfs(board, x - 1, y - 1);
        dfs(board, x - 1, y);
        dfs(board, x - 1, y + 1);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
        dfs(board, x + 1, y - 1);
        dfs(board, x + 1, y);
        dfs(board, x + 1, y - 1);
    }

    private static int[] check(char[][] board, int x, int y) {
        int countB = 0;
        int countM = 0;
        if (y - 1 >= 0 && (board[x][y - 1] == 'B' || board[x][y - 1] == 'M')) {
            if (board[x][y - 1] == 'B')
                countB++;
            else
                countM++;
        }
        if (y + 1 < board[0].length && (board[x][y + 1] == 'B' || board[x][y + 1] == 'M')) {
            if (board[x][y + 1] == 'B')
                countB++;
            else
                countM++;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && (board[x - 1][y - 1] == 'B' || board[x - 1][y - 1] == 'M')) {
            if (board[x - 1][y - 1] == 'B')
                countB++;
            else
                countM++;
        }
        if (x - 1 >= 0 && y + 1 < board[0].length && (board[x - 1][y + 1] == 'B' || board[x - 1][y + 1] == 'M')) {
            if (board[x - 1][y + 1] == 'B')
                countB++;
            else
                countM++;
        }
        if (x - 1 >= 0 && (board[x - 1][y] == 'B' || board[x - 1][y] == 'M')) {
            if (board[x - 1][y] == 'B')
                countB++;
            else
                countM++;
        }
        if (x + 1 < board.length && y + 1 < board[0].length && (board[x + 1][y + 1] == 'B' || board[x + 1][y + 1] == 'M')) {
            if (board[x + 1][y + 1] == 'B')
                countB++;
            else
                countM++;
        }

        if (x + 1 < board.length && (board[x + 1][y] == 'B' || board[x + 1][y] == 'M')) {
            if (board[x + 1][y] == 'B')
                countB++;
            else
                countM++;
        }

        if (x + 1 < board.length && y - 1 >= 0 && (board[x + 1][y - 1] == 'B' || board[x + 1][y - 1] == 'M')) {
            if (board[x + 1][y - 1] == 'B')
                countB++;
            else
                countM++;
        }
        return new int[]{countB, countM};
    }

    private static void show(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'}, {'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'}, {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'}};
        show(board);
        System.out.println();
        updateBoard(board, new int[]{0, 0});
        show(board);
    }
}


