package _861翻转矩阵后的得分;

import java.util.Map;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 1 1 0 0
 * 1 0 1 0
 * 1 1 0 0
 * <p>
 * 1 1 0 1
 * 1 0 1 1
 * 1 1 0 1
 */

//贪心思想 要使得最大 首先 每一行第一个数字要是1 ，那么如果不是1就调换
// 然后再一列一列看 如果0多就变换 1多就不变
class Solution {
    public static int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                change(A,true,i);
            }
        }
        for (int i = 1; i < A[0].length; i++) {
            if(!onebigthanzero(A,i))
            {
                change(A,false,i);
            }
        }
        int total=0;
        for (int i = 0; i < A.length; i++) {
            int sum=0;
            for (int j = A[0].length-1; j >=0; j--) {
                sum+= Math.pow(2,A[0].length-1-j)*A[i][j];
            }
            total+=sum;
        }
        return total;
    }

    public static void change(int[][] A, boolean row, int i) {
        if (row) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        } else {
            for (int j = 0; j < A.length; j++) {
                if (A[j][i] == 1) {
                    A[j][i] = 0;
                } else {
                    A[j][i] = 1;
                }
            }
        }
    }

    private static boolean onebigthanzero(int [][]A,int i)
    {
        int one=0;
        int zero=0;
        for (int j = 0; j < A.length; j++) {
            if (A[j][i] == 0) {
                zero++;
            } else {
                one++;
            }
        }
        return one>=zero;
    }

    public static void main(String[] args) {
        int[][] A =new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
//        int[][] A =new int[][]{{0,1},{1,1}};
        int score = matrixScore(A);
        System.out.println(score);
    }
}

//1 0
//1 1