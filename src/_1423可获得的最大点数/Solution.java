package _1423可获得的最大点数;

/**
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //前缀和，先算出左边的k个数总合 然后左边第数量减少 右边数量增多 算出最大那个
    public static int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int leftMaxIndex = k-1;
        int leftsum = 0;
        for (int i = 0; i < k; i++) {
            leftsum+=cardPoints[i];
        }
        max = leftsum;
        for (int i = cardPoints.length-1; i >=cardPoints.length-k ; i--) {
            leftsum=leftsum-cardPoints[leftMaxIndex--]+cardPoints[i];
            if(leftsum>max)
                max=leftsum;
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,79,80,1,1,1,200,1};
        int score = maxScore(nums, 3);
        System.out.println(score);
    }
}