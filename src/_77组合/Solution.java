package _77组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 难度
 * 中等
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (k == 0)
            return null;
        dfs(n, k, list, allList, 1);
        return allList;
    }

    private static void dfs(int n, int k, List<Integer> list, List<List<Integer>> allList, int now) {
        if (now == n+1) {
            if (list.size() == k) {
                allList.add(new ArrayList<>(list));
                return;
            }
        }
        else
        {
            list.add(now);
            dfs(n, k, list, allList, now + 1);
            list.remove(list.size() - 1);
            dfs(n, k, list, allList, now + 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(1, 1);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}