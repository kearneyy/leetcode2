package _463岛屿的周长;

/**
 * 463. 岛屿的周长
 * 难度
 * 简单
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 示例 :
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 */

//dfs，效率低
class Solution {
    static boolean checked[][];
    static int count=0;
    public static int islandPerimeter(int[][] grid) {
        int x=-1;
        int y=-1;
        checked = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)
                {
                    x=i;
                    y=j;
                    break;
                }
            }
            if(x!=-1)
                break;
        }
        dfs(x,y,grid);
        return count;
    }

    private static void dfs(int x, int y,int[][] grid) {
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0)
        {
            count++;
            return;
        }
        if(checked[x][y])
        {
            return;
        }
        checked[x][y]=true;
        dfs(x-1,y,grid);
        dfs(x+1,y,grid);
        dfs(x,y+1,grid);
        dfs(x,y-1,grid);
    }

    public static void main(String[] args) {
        int nums[][] = new int[][]{{1}};
        int i = islandPerimeter(nums);
        System.out.println(i);
    }
}