package _1025除数博弈;

/**
 * 数字N如果是奇数，它的约数必然都是奇数；若为偶数，则其约数可奇可偶。
 * 无论N初始为多大的值，游戏最终只会进行到N=2时结束，那么谁轮到N=2时谁就会赢。
 * 因为爱丽丝先手，N初始若为偶数，爱丽丝则只需一直选1，使鲍勃一直面临N为奇数的情况，这样爱丽丝稳赢；
 * N初始若为奇数，那么爱丽丝第一次选完之后N必为偶数，那么鲍勃只需一直选1就会稳赢。
 *
 * 综述，判断N是奇数还是偶数，即可得出最终结果！
 *
 * 作者：coder233
 * 链接：https://leetcode-cn.com/problems/divisor-game/solution/qi-shi-shi-yi-dao-shu-xue-ti-by-coder233/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
