package _547省份数量;

//数组写并查集

public class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i]=i;
        }

        for (int i = 0; i < provinces; i++) {
            for (int j = i+1; j <provinces; j++) {
                if(isConnected[i][j]==1)
                union(parent,i,j);
            }
        }

        int count = 0;
        for (int i = 0; i < provinces; i++) {
            if(parent[i]==i)
                count++;
        }
        return count;
    }



    public void union (int[] parent, int index1, int index2)
    {
        parent[find(parent,index1)]=find(parent,index2);
    }

    public int find(int[] parent,int index)
    {
        if(parent[index]!=index)
        {
            parent[index] = find(parent,parent[index]);
        }
        return parent[index];
    }
}
