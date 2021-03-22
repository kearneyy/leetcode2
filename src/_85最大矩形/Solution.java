package _85最大矩形;

/**
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 *
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 *
 *
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 *
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 *
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null)
            return 0;
        int chang[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int count = matrix[i][0] == '1' ? 1 : 0;
            chang[i][0] = count;
            for (int j = 1; j < matrix[0].length; j++) {
                count = matrix[i][j] == '1' ? count + 1 : 0;
                chang[i][j] = count;
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='0')continue;
                int witdh = chang[i][j];
                int area = witdh;
                for (int k = i-1; k>=0 ; k--) {
                    if(matrix[i][j]=='0')
                        break;
                    witdh=Math.min(witdh,chang[k][j]);
                    area = Math.max(area,witdh*(i-k+1));
                }
                res=Math.max(res,area);
            }
        }
        return res;
    }





    public static void main(String[] args) {
        char nums[][] = new char[][]  {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int i = maximalRectangle(nums);

        System.out.println(i);
    }
}
