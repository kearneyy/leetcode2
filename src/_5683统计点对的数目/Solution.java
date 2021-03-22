package _5683统计点对的数目;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个无向图，无向图由整数 n  ，表示图中节点的数目，和 edges 组成，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条无向边。同时给你一个代表查询的整数数组 queries 。
 *
 * 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目：
 *
 *     a < b
 *     cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。
 *
 * 请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答案。
 *
 * 请注意，图中可能会有 重复边 。
 */

//超时
class Solution {
    public static int[] countPairs(int n, int[][] edges, int[] queries) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <n; i++) {
            for (int j = i+1; j <=n; j++) {
                int count = 0;
                for (int k = 0; k < edges.length; k++) {
                    if(edges[k][0]==i||edges[k][1]==j||edges[k][0]==j||edges[k][1]==i)
                    {
                        count++;
                    }
                }
                list.add(count);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j)>queries[i])
                {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{2,4},{1,3},{2,3},{2,1}};
        int[] ints = countPairs(4, nums, new int[]{2, 3});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}