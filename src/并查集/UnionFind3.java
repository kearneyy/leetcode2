package 并查集;


import java.util.Arrays;

class UnionFind3 {
    int[] parent;
    int[] size;
    int n;
    // 当前连通分量数目
    int setCount;

    //初始化
    public UnionFind3(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    //找根节点
    public int findset(int x) {
        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
    }

    //合并
    public boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    //如果xy是连接的 有同一个根节点
    public boolean connected(int x, int y) {
        x = findset(x);
        y = findset(y);
        return x == y;
    }
}
