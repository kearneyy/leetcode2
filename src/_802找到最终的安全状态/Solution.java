package _802找到最终的安全状态;

import java.util.*;

/**
 * 在有向图中, 我们从某个节点和每个转向处开始, 沿着图的有向边走。 如果我们到达的节点是终点 (即它没有连出的有向边), 我们停止。
 *
 * 现在, 如果我们最后能走到终点，那么我们的起始节点是最终安全的。 更具体地说, 存在一个自然数 K,  无论选择从哪里开始行走, 我们走了不到 K 步后必能停止在一个终点。
 *
 * 哪些节点最终是安全的？ 结果返回一个有序的数组。
 *
 * 该有向图有 N 个节点，标签为 0, 1, ..., N-1, 其中 N 是 graph 的节点数.  图以以下的形式给出: graph[i] 是节点 j 的一个列表，满足 (i, j) 是图的一条有向边。
 *
 * 示例：
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 这里是上图的示意图。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 拓扑排序
 */
class Solution {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int[] degree = new int[graph.length];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int key = graph[i][j];
                List<Integer> list = map.getOrDefault(key,new ArrayList<>());
                list.add(i);
                map.put(key,list);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < degree.length; i++) {
            if(degree[i]==0)
            {
                queue.add(i);
                ans.add(i);
            }
        }
        while (queue.size()!=0)
        {
            Integer poll = queue.poll();
            List<Integer> list = map.get(poll);
            if(list!=null)
            {
                for (Integer integer : list) {
                    degree[integer]--;
                    if(degree[integer]==0)
                    {
                        queue.add(integer);
                        ans.add(integer);
                    }
                }
            }

        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> list = eventualSafeNodes(graph);
        System.out.println(list);
    }
}
