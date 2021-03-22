package _1584连接所有点的最小费用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//模板
// 定义边
class Edge {
    // 分别表示一条边两个点的索引和边长
    int a, b, val;
    public Edge(int a, int b, int val) {
        this.a = a;
        this.b = b;
        this.val = val;
    }
}

class Solution {
    // 并查集集合
    List<Integer> p;
    public int minCostConnectPoints(int[][] points) {
        p = new ArrayList<>();
        int n = points.length;
        // 初始化并查集
        for(int i = 0; i < n; i++) {
            p.add(i);
        }
        // 添加所有可能的边到列表中
        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                // 添加第i个点和第j个点组成的边
                edges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        // 进行一个升序排序，为了优先选取短的边
        Collections.sort(edges, (a, b) -> a.val - b.val);

        // 从低到高遍历所有边
        int res = 0;
        for(Edge e : edges) {
            // 查找这条边两个端点所处的集合根元素
            int a = find(e.a), b = find(e.b);
            // 如果这两条边不是一个集合的，那么就添加这条边
            if(a != b) {
                // 并且将这两个点所在的集合根元素加入一个集合
                p.set(a, b);
                // 答案中添加这条边长度
                res += e.val;
            }
        }

        return res;
    }

    // 并查集模板方法，用于查找根元素
    public int find(int x) {
        if(p.get(x) != x) {
            p.set(x, find(p.get(x)));
        }

        return p.get(x);
    }
}

