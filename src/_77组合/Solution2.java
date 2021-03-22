package _77组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码改进
 */
class Solution2 {
    static List<List<Integer>> allList = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return allList;
    }

    private static void dfs(int n, int k, int now) {
        if (list.size() + (n - now + 1) < k)
            return;
        if (list.size() == k) {
            allList.add(new ArrayList<>(list));
            return;
        }
        list.add(now);
        dfs(n, k, now + 1);
        list.remove(list.size() - 1);
        dfs(n, k, now + 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combine(1, 1);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}