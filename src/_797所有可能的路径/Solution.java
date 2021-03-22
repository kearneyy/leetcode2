package _797所有可能的路径;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


//深搜回溯
class Solution {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(deque, ans, graph, 0);
        return ans;
    }

    public static void dfs(Deque<Integer> deque, List<List<Integer>> ans, int[][] graph, int index) {
        if (index == graph.length - 1) {
            deque.add(index);
            ans.add(new ArrayList<>(deque));
            deque.removeLast();
            return;
        }
        if (graph[index] == null) {
            return;
        }
        int[] num = graph[index];
        deque.add(index);
        for (int j = 0; j < num.length; j++) {
            dfs(deque, ans, graph, num[j]);
        }
        deque.removeLast();
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = allPathsSourceTarget(num);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}