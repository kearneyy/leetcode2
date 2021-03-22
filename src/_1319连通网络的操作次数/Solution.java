package _1319连通网络的操作次数;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class unionfind{
    int[] parents;
    int[] size;
    int setCounts;
    int n;

    public unionfind(int n){
        this.n = n;
        parents = new int[n];
        size = new int[n];
        setCounts = n;
        Arrays.fill(size,1);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int findset(int x){
        return parents[x]==x?x:findset(parents[x]);
    }

    public boolean isconnected(int x,int y)
    {
        return findset(x)==findset(y);
    }

    public boolean unite(int x,int y){
        int rootx = findset(x);
        int rooty = findset(y);
        if (rootx==rooty)
            return false;
        if (size[rootx]<size[rooty]) {
            int temp = rootx;
            rootx = rooty;
            rooty = temp;
        }
        parents[rooty]=rootx;
        size[rootx]+=size[rooty];
        --setCounts;
        return true;
    }


}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        unionfind uf = new unionfind(n);
        for (int[] connection : connections) {
            uf.unite(connection[0],connection[1]);
        }
        return uf.setCounts-1;
    }
}
