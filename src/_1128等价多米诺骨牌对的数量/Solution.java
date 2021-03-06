package _1128等价多米诺骨牌对的数量;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int total = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            int num1 = dominoe[0];
            int num2 = dominoe[1];
            if(num2>num1)
            {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            int num  = num1*10+num2;
            Integer count = map.getOrDefault(num, 0);
            total+=count;
            map.put(num,count+1);
        }
        return total;
    }
}