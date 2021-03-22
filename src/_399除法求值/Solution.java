package _399除法求值;

import javax.print.attribute.standard.Finishings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 *
 * 示例 2：
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 *
 *
 * 示例 3：
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        Map<String,Integer> map = new HashMap<>(size*2);
        int index = 0;
        unionfind uf = new unionfind(size*2);
        int vaindex = 0;
        for (List<String> equation : equations) {
            String str0 = equation.get(0);
            String str1 = equation.get(1);
            if(!map.containsKey(str0))
            {
                map.put(str0,index++);
            }
            if(!map.containsKey(str1))
            {
                map.put(str1,index++);
            }
            uf.union(map.get(str0),map.get(str1),values[vaindex++]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            String var0 = list.get(0);
            String var1 = list.get(1);
            Integer int0 = map.get(var0);
            Integer int1 = map.get(var1);
            if(int0==null||int1==null)
            {
                res[i] = -1.0d;
            }
            else
            {
                res[i] = uf.connected(int0,int1);
            }
        }
        return res;
    }

    class unionfind{
        private int[] parents;
        private double[] weigh;
        int n;

        public unionfind(int n){
            this.n = n;
            parents = new int[n];
            weigh = new double[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i]=i;
                weigh[i] = 1.0d;
            }
        }

        public void union(int x,int y,double value){
         int rootX = find(x);
         int rootY = find(y);
         if(rootX==rootY)
             return;
         parents[rootX] = rootY;
         weigh[rootX] = value*weigh[y]/weigh[x];
        }

        public int find(int x){
            if (x!=parents[x])
            {
                int original = parents[x];
                parents[x] = find(parents[x]);
                weigh[x] *=weigh[original];
            }
            return parents[x];
        }

        public double connected(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX!=rootY)
                return -1.0d;
            return weigh[x]/weigh[y];
        }
    }
}