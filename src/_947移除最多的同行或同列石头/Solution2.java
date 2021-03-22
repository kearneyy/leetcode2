package _947移除最多的同行或同列石头;

import java.util.HashMap;
import java.util.Map;


//用了一个map来维护连通分量的个数
public class Solution2 {


    class unionfind {
        private Map<Integer, Integer> parent;
        private int count;

        public unionfind(int n) {
            count = 0;
            parent = new HashMap<>();

        }


        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            parent.put(rootX, rootY);
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public int removeStones(int[][] stones) {
        unionfind uf = new unionfind(stones.length);

        for (int[] stone : stones) {
            // 下面这三种写法任选其一
            // unionFind.union(~stone[0], stone[1]);
            // unionFind.union(stone[0] - 10001, stone[1]);
            uf.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - uf.getCount();
    }


}