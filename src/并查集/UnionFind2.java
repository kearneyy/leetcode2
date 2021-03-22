package 并查集;

//数组写法
public class UnionFind2 {

    public void Union(int[][] num) {
        int nums = num.length;
        int[] parent = new int[nums];
        for (int i = 0; i < nums; i++) {
            parent[i] = i;
        }
    }


    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
