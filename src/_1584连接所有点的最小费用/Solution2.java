package _1584连接所有点的最小费用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Edge2{
    int a,b,val;
    public Edge2(int a,int b,int val){
        this.a=a;
        this.b=b;
        this.val=val;
    }
}


public class Solution2 {

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] parent = new int[n];
        int total = 0;
        List<Edge2> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent[i]=i;
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                list.add(new Edge2(i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }

        Comparator<Edge2> comparator = new Comparator<Edge2>() {
            @Override
            public int compare(Edge2 o1, Edge2 o2) {
                return o1.val-o2.val;
            }
        };


        Collections.sort(list,comparator);

        for (Edge2 edge2 : list) {
            int a = find(parent,edge2.a);
            int b = find(parent,edge2.b);
            if(a!=b)
            {
                parent[a] = b;
                total+=edge2.val;
            }
        }
        return total;
    }

    public static int find(int[] parent,int x){
        if(parent[x]!=x)
        {
            parent[x]=find(parent,parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        int i = minCostConnectPoints(num);
        System.out.println(num);
    }
}


