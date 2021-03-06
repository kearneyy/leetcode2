package _1631最小体力消耗路径;

import java.util.*;

/**
 * v你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//并查集
class unionfind {
    int[] parent;

    public unionfind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }


    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return false;
        parent[rootX] = rootY;
        return true;
    }


    public boolean isconnected(int x, int y) {
        return find(x) == find(y);
    }

}

class Edge {
    int from;
    int to;
    int weigh;

    public Edge(int from, int to, int weigh) {
        this.from = from;
        this.to = to;
        this.weigh = weigh;
    }
}

class Solution {


    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int size = m * n;
        unionfind uf = new unionfind(size);
        int edgem = (n - 1) * m;
        int edgen = (m - 1) * n;
        int edgesize = edgem + edgen;
        Edge[] edges = new Edge[edgesize];
        int edgeindex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    edges[edgeindex++] = new Edge(i * n + j, i * n + j + 1, Math.abs(heights[i][j] - heights[i][j + 1]));
                }
                if (i < m - 1) {
                    edges[edgeindex++] = new Edge(i * n + j, i * n + j + n, Math.abs(heights[i + 1][j] - heights[i][j]));
                }
            }
        }
        Comparator<Edge> comparator = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weigh - o2.weigh;
            }
        };
        int res = 0;
        Arrays.sort(edges, comparator);
        for (Edge edge : edges) {
            uf.union(edge.from, edge.to);
            if (uf.isconnected(0, size - 1)) {
                res = edge.weigh;
                break;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] hei = new int[][]{{10,8},{10,8},{1,2},{10,3},{1,3},{6,3},{5,2}};
        int i = minimumEffortPath(hei);
        System.out.println(i);
    }
}