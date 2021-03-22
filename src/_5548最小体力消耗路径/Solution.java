package _5548最小体力消耗路径;

class Solution {

    private static int rows, cols;
    private static int max_diff;
    private static int[][] visited;
    private static int[] dirx = {0, -1, 1, 0};
    private static int[] diry = {1, 0, 0, -1};

    public static void dfs(int x, int y, int diff,int[][] heights) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) return ;
        if (diff >= max_diff) return ;
        if (diff >= visited[x][y]) return ;
        if (x == rows - 1 && y == cols - 1) {
            max_diff = Math.min(max_diff, diff);
            return ;
        }
        visited[x][y] = diff;
        for (int i = 0; i < 4; i++) {
            int nx = x + dirx[i], ny = y + diry[i];
            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) continue ;
            int temp_diff = Math.max(diff, Math.abs(heights[x][y] - heights[nx][ny]));
            dfs(nx, ny, temp_diff,heights);
        }
    }

    public static int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        visited = new int[rows][cols];
        max_diff = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = max_diff;
            }
        }
        dfs(0, 0, 0,heights);
        return max_diff;
    }

    public static void main(String[] args) {
        int nums[][] = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        int i = minimumEffortPath(nums);
        System.out.println(i);
    }

}