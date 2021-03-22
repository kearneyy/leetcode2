package _115不同的子序列;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * 示例 2：
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 我来解释下2个问题，1： 为啥状态方程这样对？ 2：怎么想到这样的状态方程？
 *
 * 我个人习惯dp[i][j] 表示为s[0-i] 和t[0-j]均闭区间的子序列个数，但这样不能表示s和t空串的情况
 *
 * 所以声明 int[][] dp = new int[m + 1][n + 1]; 这样dp[0][x]可以表示s为空串，dp[x][0]同理。
 *
 * 先不扣初始化的细节，假设dp[i][j] 就是s[i] 和t[j] 索引的元素子序列数量
 *
 * 1：为啥状态方程是： s[i] == t[j] 时 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 *
 * s[i] != t[j] 时 dp[i][j] = dp[i-1][j]
 *
 * 先看s[i] == t[j] 时，以s = "rara" t = "ra" 为例，当i = 3, j = 1时，s[i] == t[j]。
 *
 * 此时分为2种情况，s串用最后一位的a + 不用最后一位的a。
 *
 * 如果用s串最后一位的a,那么t串最后一位的a也被消耗掉，此时的子序列其实=dp[i-1][j-1]
 *
 * 如果不用s串最后一位的a，那就得看"rar"里面是否有"ra"子序列的了，就是dp[i-1][j]
 *
 * 所以 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 *
 * 再看s[i] != t[j] 比如 s = "rarb" t = "ra" 还是当i = 3, j = 1时，s[i] != t[j]
 *
 * 此时显然最后的b想用也用不上啊。所以只能指望前面的"rar"里面是否有能匹配"ra"的
 *
 * 所以此时dp[i][j] = dp[i-1][j]
 *
 * 2: 怎么想到这样状态方程的？
 *
 * 一点个人经验，见过的很多2个串的题，大部分都是dp[i][j] 分别表示s串[0...i] 和t串[0...j]怎么怎么样 然后都是观察s[i]和t[j]分等或者不等的情况 而且方程通常就是 dp[i-1][j-1] 要么+ 要么 || dp[i-1][j]类似的
 *
 * 类似的题比如有 10：正则表达式匹配 44：通配符匹配 编辑距离 1143：最长公共子序列等等的 还有几道想不起来了
 */
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[m][n];
    }
}