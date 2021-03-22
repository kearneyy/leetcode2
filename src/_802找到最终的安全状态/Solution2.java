package _802找到最终的安全状态;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
//https://leetcode-cn.com/problems/find-eventual-safe-states/solution/zhao-dao-zui-zhong-de-an-quan-zhuang-tai-by-leetco/

class Solution2 {
    public  List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> list = new ArrayList<>();
    int[] color =new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            //遍历每一个点
            if(dfs(i,color,graph))
            {
                list.add(i);
            }
        }
        return list;
    }

    //0白色 1灰色 2黑色
    public boolean dfs(int node,int[] color,int[][] graph){
        //如果已经上色但是是黑色就返回true，灰色返回false
        if(color[node]>0)
            return color[node] ==2;
        color[node]=1;//遇到先变成灰色
        for (int i : graph[node]) {
            if(color[i]==2)//如果遇到黑色跳过
                continue;
            if(color[i]==1||!dfs(i,color,graph))//如果遇到灰色或者由它深度遍历会有灰色
            {
                return false;
            }
        }
        //如果没有遇到灰色 回溯改成黑色
        color[node] = 2;
        return true;
    }

}