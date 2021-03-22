package _1579保证图可完全遍历;


/**
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *
 *
 * 	类型 1：只能由 Alice 遍历。
 * 	类型 2：只能由 Bob 遍历。
 * 	类型 3：Alice 和 Bob 都可以遍历。
 *
 *
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
 *
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * 输出：2
 * 解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所以可以删除的最大边数是 2 。
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
 * 输出：0
 * 解释：注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
 *
 *
 * 示例 3：
 *
 *
 *
 * 输入：n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
 * 输出：-1
 * 解释：在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//并查集
class Solution {
    class unionfind{
        int[] parent;
        int[] size;
        int count;

        public unionfind(int n){
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            while (parent[x]!=x)
            {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX==rootY)
                return false;
            if(size[x]<size[y])
            {
                parent[rootX] = rootY;
                size[y]+=size[x];
            }
            else
            {
                parent[rootY] = rootX;
                size[x]+=size[y];
            }
            count--;
            return true;
        }

        public int getSize(int x) {
            int rootX = find(x);
            return size[rootX];
        }

        public boolean isconnected(int x,int y){
            return find(x)==find(y);
        }

        public void copyunion(int[] copyparent,int[] copysize,int copycount,int n){
            for (int i = 0; i < n; i++) {
                parent[i] = copyparent[i];
                size[i] = copysize[i];
            }
            count = copycount;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int ans = 0;
        unionfind uf = new unionfind(n);
        unionfind ufa = new unionfind(n);
        unionfind ufb = new unionfind(n);
        for (int i = 0; i < edges.length; i++) {
            edges[i][1]--;
            edges[i][2]--;
            if(edges[i][0]==3)
            {
                if(uf.union(edges[i][1],edges[i][2]))
                {
                    ans++;
                }
            }
        }
        ufa.copyunion(uf.parent,uf.size,uf.count,n);
        ufb.copyunion(uf.parent,uf.size,uf.count,n);
        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0]==1)
            {
                if(ufa.union(edges[i][1],edges[i][2]))
                {
                    ans++;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0]==2)
            {
                if(ufb.union(edges[i][1],edges[i][2]))
                {
                    ans++;
                }
            }
        }
        if(ufa.count>1||ufb.count>1)
        return -1;
        return edges.length-ans;
    }
}
