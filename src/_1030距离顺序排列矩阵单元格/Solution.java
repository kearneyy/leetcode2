package _1030距离顺序排列矩阵单元格;

import java.util.*;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 *
 *
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 *
 *
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class point{
    public point(int x,int y,int d){
        this.x=x;
        this.y=y;
        this.d=d;
    }
    int x;
    int y;
    int d;

}

class Solution {



    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<point> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                list.add(new point(i,j, Math.abs(i-r0)+Math.abs(j-c0)));
            }
        }
        Comparator<point> comparator = new Comparator<point>() {
            @Override
            public int compare(point o1, point o2) {
                return o1.d-o2.d;
            }
        };
        Collections.sort(list,comparator);
        int nums[][] = new int[R*C][2];
        for (int i = 0; i < R*C; i++) {
            nums[i][0]=list.get(i).x;
            nums[i][1]=list.get(i).y;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] ints = allCellsDistOrder(2, 2, 0, 1);
        for (int[] anInt : ints) {
            System.out.println(anInt[0]+" "+anInt[1]);
        }
    }
}
