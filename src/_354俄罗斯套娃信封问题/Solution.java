package _354俄罗斯套娃信封问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//二维的最长递增子序列
class Solution {
    public static int maxEnvelopes(int[][] envelopes) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0]==o1[0])
                    return o1[1]-o2[1];
                else
                    return o1[0]-o2[0];
            }
        };
        Arrays.sort(envelopes,comparator);
        int res = 0;
        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1])
                {
                    max = Math.max(dp[j],max);
                }
                dp[i] = max+1;
            }
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(dp[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1},{1,1},{1,1}};
        int i = maxEnvelopes(nums);
        System.out.println(i);
    }
}
