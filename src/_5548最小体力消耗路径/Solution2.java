package _5548最小体力消耗路径;

class Solution2 {
    public static int minimumEffortPath(int[][] heights) {
        int left = 0, right = 1000000;
        while (left < right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[heights.length][heights[0].length];
            minimumEffortPath(0, 0, mid, heights, visited);
            if (visited[heights.length - 1][heights[0].length - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static void minimumEffortPath(int i, int j, int effort, int[][] heights, boolean[][] visited) {
        if (!visited[i][j]) {
            visited[i][j] = true;
            if (i > 0 && Math.abs(heights[i - 1][j] - heights[i][j]) <= effort) {
                minimumEffortPath(i - 1, j, effort, heights, visited);
            }
            if (j > 0 && Math.abs(heights[i][j - 1] - heights[i][j]) <= effort) {
                minimumEffortPath(i, j - 1, effort, heights, visited);
            }
            if (j < heights[0].length - 1 && Math.abs(heights[i][j + 1] - heights[i][j]) <= effort) {
                minimumEffortPath(i, j + 1, effort, heights, visited);
            }
            if (i < heights.length - 1 && Math.abs(heights[i + 1][j] - heights[i][j]) <= effort) {
                minimumEffortPath(i + 1, j, effort, heights, visited);
            }
        }
    }

    public static void main(String[] args) {
        int nums[][] = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        int i = minimumEffortPath(nums);
        System.out.println(i);
    }
}