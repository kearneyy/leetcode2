package 并查集;

class UF {
    public int[] parent;  // parent[i]  i 的 父节点
    public int[] size;   // i 所在的连通分量的大小，为了union的时候，将小树的root连接到大树的root下
    public int count;    // 有几个连通分量

    public UF (int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int root(int i) {  // 找root，并且两步一跳来路径压缩，让树尽量扁平
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public void union(int i, int j) {   // union 可以返回 void, boolean
        int rootI = root(i);
        int rootJ = root(j);
        if (rootI == rootJ) return;  // 已经在一个连通分量里面了
        if (size[i] > size[j]) {     // 把小树连接到大树上，保证整棵树尽量矮，查找起来快
            parent[rootJ] = rootI;
            size[rootI] += size[rootJ];
        } else {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        }
        count--;
    }

    public int getSize(int i) {   // i 所在的连通分量的大小
        int rootI = root(i);
        return size[rootI];
    }
}

public class UnionFind4 {
}
