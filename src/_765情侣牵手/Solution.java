package _765情侣牵手;

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 *
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 *
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 示例 1:
 *
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 *
 *
 * 示例 2:
 *
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//并查集 找连通分量
class unionfind{
    int n;
    int[] parent;
    int[] size;
    int count;

    public unionfind(int n){
        this.n = n;
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
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
        return parent[x];
    }

    public boolean union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY)
        {
            return false;
        }
        else
        {
            if (size[x]<size[y])
            {
                parent[rootX] = rootY;
                size[rootY]+=size[rootX];
            }
            else
            {
                parent[rootY] = rootX;
                size[rootX]+=size[rootY];
            }
        }
        count--;
        return true;
    }
}

class Solution {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int halflen = len/2;
        unionfind uf = new unionfind(halflen);
        for (int i = 0; i < row.length; i=i+2) {
            uf.union(row[i]/2,row[i+1]/2);
        }
        return halflen-uf.count;
    }
}