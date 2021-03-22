package _5665从相邻元素对还原数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * <p>
 * 示例 1：
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 */


//超时
class Solution {
    public  static  int[] restoreArray(int[][] adjacentPairs) {
        boolean[] visited = new boolean[adjacentPairs.length];
        int beginnum = 0;
        int lastnum = 0;
        int flag = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            Integer num1 = map.getOrDefault(adjacentPairs[i][0], 0);
            Integer num2 = map.getOrDefault(adjacentPairs[i][1], 0);
            num1++;
            num2++;
            map.put(adjacentPairs[i][0], num1);
            map.put(adjacentPairs[i][1], num2);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1) {
                if (flag == 0) {
                    beginnum = entry.getKey();
                    flag++;
                }
                else {
                    lastnum = entry.getKey();
                    break;
                }
            }
        }
        int beginindex = 0;
        for (int i = 0; i < adjacentPairs.length; i++) {
            if (adjacentPairs[i][0] == beginnum || adjacentPairs[i][1] == beginnum) {
                beginindex = i;
                break;
            }
        }
        int[] res = new int[adjacentPairs.length+1];
        Arrays.fill(res, 100001);
        res[0] = beginnum;
        int index = 1;
        dfs(adjacentPairs, visited, beginnum, lastnum, res, index);
        return res;
    }

    public static void dfs(int[][] adjacentPairs, boolean[] visited, int beginnum, int lastnum, int[] res, int index) {
        if (beginnum == lastnum)
            return;
        for (int i = 0; i < adjacentPairs.length; i++) {
            if (!visited[i]) {
                int num1 = adjacentPairs[i][0];
                int num2 = adjacentPairs[i][1];
                if (num1 == beginnum || num2 == beginnum) {
                    if (num1 == beginnum) {
                        if(num2 == lastnum&&res[res.length-2]==100001)
                        {
                            continue;
                        }
                        res[index++] = num2;
                        beginnum = num2;
                    } else {
                        if(num1 == lastnum&&res[res.length-2]==100001)
                        {
                            continue;
                        }
                        res[index++] = num1;
                        beginnum = num1;
                    }
                    visited[i] = true;
                    dfs(adjacentPairs,visited,beginnum,lastnum,res,index);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{2,1},{3,4},{3,2}};
        int[] ints = restoreArray(num);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
