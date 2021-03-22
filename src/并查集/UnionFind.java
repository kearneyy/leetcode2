package 并查集;

import java.util.HashMap;
import java.util.Map;


//这里是构造了一个数据结构
//用map来存对应关系 前面的是键 后面的是他的父节点
public class UnionFind {
    private Map<Integer,Integer> father;

    public UnionFind(){
        father = new HashMap<Integer, Integer>();
    }

    //根的父节点都设置为null
    public void add(int x){
        if(!father.containsKey(x))
        {
            father.put(x,null);
        }
    }

    public void merge(int x,int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY)
        {
            father.put(rootX,rootY);
        }
    }

    //优化过后 不处理x会弄成一个很长的链表，时间复杂度太低
    public int find(int x)
    {
        int root = x;

        //找到根节点
        while(father.get(root)!=null)
        {
            root=father.get(root);
        }

        //优化 把一长串链表移到根节点下面
        while (x!=root)
        {
            int original_father = father.get(x);
            father.put(x,root);
            x = original_father;
        }
        return root;
    }

    public boolean isConnected(int x,int y)
    {
        return find(x)==find(y);
    }
}
