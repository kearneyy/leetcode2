package _947移除最多的同行或同列石头;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 *
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 *
 * 示例 2：
 *
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 *
 * 示例 3：
 *
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//多加了size但是没什么优化效率还是低
public class Solution3 {

    class unionfind{
        private int[] parent;
        int[] size;
        Set<Integer> set = new HashSet<>();

        public unionfind(int n){
            this.size = new int[n];
            Arrays.fill(size, 1);
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                set.add(i);
            }
        }

        public Set<Integer> getSet() {
            return set;
        }

        public int find(int x){
            if(parent[x]!=x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x,int y){
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            set.remove(y);
            set.add(x);
            return true;
        }

    }

    public  int removeStones(int[][] stones) {
        unionfind uf = new unionfind(stones.length);
        for (int i = 0; i < stones.length-1; i++) {
            for (int j = i+1; j <stones.length; j++) {
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1])
                {
                    uf.union(i,j);
                }
            }
        }
        int getlong = uf.getSet().size();
        return stones.length-getlong;
    }

}