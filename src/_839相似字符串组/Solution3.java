package _839相似字符串组;

import java.util.Arrays;

class Solution3 {
    public int numSimilarGroups(String[] strs) {
        //strs[i] 只包含小写字母。strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(comapre(strs,i,j)){
                    uf.union(i,j);
                }
            }
        }
        return uf.setCount;
    }
    public boolean comapre(String[] strs,int i,int j){
        String str1 = strs[i],str2 = strs[j];
        int len = str1.length();
        //System.out.println(str1 + "   " + str2);
        int count = 0;
        for(int k = 0; k < len;k++){
            if(str1.charAt(k) != str2.charAt(k)){
                count++;
                if(count > 2){
                    return false;
                }
            }
        }
        //System.out.println(count == 2);
        return count == 2 || count == 0;

    }
    class UnionFind{
        int[] parent;
        int[] rank;
        int n;
        int setCount;
        public UnionFind(int n){
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            Arrays.fill(parent,-1);
            this.rank = new int[n];
        }
        public int findRoot(int x){
            int xRoot = x;
            while(parent[xRoot] != -1){
                xRoot = parent[xRoot];
            }
            return xRoot;
        }

        public boolean union(int x,int y){
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            if(xRoot == yRoot){
                return false;
            }

            if(rank[xRoot] > rank[yRoot]){
                int tem = xRoot;
                xRoot = yRoot;
                yRoot = tem;
            }
            parent[xRoot] = yRoot;
            setCount--;
            rank[yRoot] = rank[xRoot] == rank[yRoot] ? rank[yRoot] + 1 : rank[yRoot];
            return true;
        }


    }
}