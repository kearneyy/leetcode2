package _547省份数量;

import java.util.HashMap;
import java.util.Map;

/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 *
 * 并查集
 */
class UnionFind{
    private Map<Integer,Integer> father;
    private int numofSets = 0;

    public UnionFind(){
        father = new HashMap<Integer, Integer>();
        numofSets = 0;
    }

    public void add(int x)
    {
        if(!father.containsKey(x))
        {
            father.put(x,null);
            numofSets++;
        }
    }

    public void merge(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY)
        {
            father.put(rootX,rootY);
            numofSets--;
        }
    }

    public int find(int x)
    {
        int root = x;
        while (father.get(root)!=null)
        {
            root=father.get(root);
        }

        while (x!=root)
        {
            int original_root = father.get(x);
            father.put(x,root);
            x = original_root;
        }
        return root;
    }

    public boolean isConnected(int x,int y){
        return find(x)==find(y);
    }

    public int getNumofSets() {
        return numofSets;
    }
}


class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf  = new UnionFind();
        for (int i = 0; i < isConnected.length; i++) {
            uf.add(i);
            for (int j = 0; j < i; j++) {
                if(isConnected[i][j]==1)
                {
                    uf.merge(i,j);
                }
            }
        }
        return uf.getNumofSets();
    }
}
