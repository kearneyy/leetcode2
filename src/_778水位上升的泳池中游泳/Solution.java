package _778水位上升的泳池中游泳;

/**
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 *
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 *
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[0,2],[1,3]]
 * 输出: 3
 * 解释:
 * 时间为0时，你位于坐标方格的位置为 (0, 0)。
 * 此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
 *
 * 等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
 *
 *
 * 示例2:
 *
 * 输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * 输出: 16
 * 解释:
 *  0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 *
 * 最终的路线用加粗进行了标记。
 * 我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



class unionfind{
    int[] parent;
    int[] size;
    int count;

    public unionfind(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
            size[i]=1;
        }
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
        if(size[x]>size[y])
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

    public boolean isconnected(int x,int y){
        return find(x)==find(y);
    }


}
class Solution {
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] index = new int[n*n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                index[num][0] = i;
                index[num][1] = j;
            }
        }
        unionfind uf = new unionfind(n*n);
        int i = 0;
        for (; i < index.length; i++) {
            int x = index[i][0];
            int y = index[i][1];
            union(x,y,n,uf,grid);
            if(uf.isconnected(grid[0][0],grid[n-1][n-1]))
            {
                break;
            }
        }
        return i;
    }

    public static void union(int x,int y,int n,unionfind uf,int[][] grid){
        if(x>0)
        {
            if(grid[x-1][y]<grid[x][y])
            {
                uf.union(grid[x-1][y],grid[x][y]);
            }
        }
        if(y>0)
        {
            if(grid[x][y-1]<grid[x][y])
            {
                uf.union(grid[x][y-1],grid[x][y]);
            }
        }
        if(x<n-1)
        {
            if(grid[x+1][y]<grid[x][y])
            {
                uf.union(grid[x+1][y],grid[x][y]);
            }
        }
        if(y<n-1)
        {
            if(grid[x][y+1]<grid[x][y])
            {
                uf.union(grid[x][y+1],grid[x][y]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int i = swimInWater(grid);
        System.out.println(i);
    }
}