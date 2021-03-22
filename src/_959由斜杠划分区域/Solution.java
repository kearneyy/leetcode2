package _959由斜杠划分区域;

/**
 *
 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。

 （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。

 返回区域的数目。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class unionfind{
    private int[] parent;
    private int num;

    public int getNum() {
        return num;
    }

    public unionfind(int n){
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }
        num = n;
    }

    public int find(int x){
        return x==parent[x]?x:(parent[x] = find(parent[x]));
    }

    public void union(int x,int y){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx==rooty)
            return ;
        parent[rooty]=rootx;
        num--;
    }
}


class Solution {
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        int size = 4*len*len;
        unionfind uf = new unionfind(size);
        for (int i = 0; i <len; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                int index = 4*(i*len+j);
                if(c=='/')
                {
                   uf.union(index,index+3);
                   uf.union(index+1,index+2);
                }
                else if(c=='\\')
                {
                    uf.union(index,index+1);
                    uf.union(index+2,index+3);
                }
                else
                {
                    uf.union(index,index+1);
                    uf.union(index+1,index+2);
                    uf.union(index+2,index+3);
                }
                if(j<len-1)
                {
                    uf.union(index+1,4*(i*len+(j+1))+3);
                }
                if(i<len-1)
                {
                    uf.union(index+2,4*((i+1)*len+j));
                }
            }

        }
        return uf.getNum();
    }
}