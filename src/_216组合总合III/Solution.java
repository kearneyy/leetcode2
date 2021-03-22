package _216组合总合III;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 * 难度
 * 中等
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
class Solution {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        if(k==0)
            return lists;
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(lists,deque,1,n,k);
        return lists;
    }

    private static void dfs(List<List<Integer>> lists,Deque<Integer> deque,int begin,int n,int k){
        if(deque.size()==k)
        {
            if(n==0)
            {
                lists.add(new ArrayList<>(deque));
            }
            return;
        }
        for (int i = begin; i <=9 ; i++) {
            if(n-i<0)
            {
                return;
            }
            deque.add(i);
            dfs(lists,deque,i+1,n-i,k);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(4,15);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}