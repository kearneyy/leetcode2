package _48旋转图像;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//一到二维的时候就有问题
class Solution {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int first = 0;
        int last = n-1;
        while (n>1)
        {
            int num[] = new int[n-1];
            int count=0;
            for (int i = first; i <= last-1; i++) {
                num[count++]=matrix[i][first];
            }
            for (int i = first; i <= last; i++) {
                matrix[i][first]=matrix[last][i];
            }
            for (int i = last-1; i >=first ; i--) {
                matrix[last][last-i]=matrix[i][last];
            }
            for (int i = last-1; i >=first+1; i--) {
                matrix[i][last]=matrix[first][i];
            }
            count=0;
            for (int i = last; i >=first+1 ; i--) {
                matrix[first][i]=num[count];
                count++;
            }
            first++;
            last--;
            n=n-2;
        }

    }

    public static void main(String[] args) {
        int nums[][] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(nums);
    }
}