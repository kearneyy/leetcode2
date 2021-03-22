package _1267统计参与通信的服务器;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-servers-that-communicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//并查集一遍过 but效率太低了
class unionfind{
    int[] parent;
    int[] size;
    int count;

    public unionfind(int n){
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public int find(int x){
        while (x!=parent[x])
        {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY)return false;
        if(size[rootX]>size[rootY])
        {
            parent[rootY] = rootX;
            size[rootX]+=size[rootY];
        }
        else
        {
            parent[rootX] = rootY;
            size[rootY]+=size[rootX];
        }
        count--;
        return true;
    }

    public int getSize(int x) {   // i 所在的连通分量的大小
        int rootX = find(x);
        return size[rootX];
    }

    public int[] getParent() {
        return parent;
    }
}

class Solution {


    public int countServers(int[][] grid) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)
                {
                    int[] num = new int[]{i,j};
                    list.add(num);
                }
            }
        }
        unionfind uf = new unionfind(list.size());
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                int[] listi = list.get(i);
                int[] listj = list.get(j);
                if(listi[0]==listj[0]||listi[1]==listj[1])
                {
                    uf.union(i,j);
                }
            }
        }
        int count = 0;
        int[] parent = uf.getParent();
        for (int i = 0; i < list.size(); i++) {
            if(uf.getSize(parent[i])>1)
            {
                count++;
            }
        }
        return count;
    }
}