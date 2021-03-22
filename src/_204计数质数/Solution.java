package _204计数质数;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 难度
 * 简单
 *
 * 571
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 接收动态
 *
 * 反馈
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 */
class Solution {
    public static int countPrimes(int n) {
        boolean nums[] = new boolean[n];
        Arrays.fill(nums,true);
        for (int i = 2; i *i< n; i++) {//这里是i*i 因为这里是筛选过程，到i平方等于n后 再大 后面的都筛选过了
            if(nums[i])//如果nums[i]是素数，开始筛选
            {
                for (int j = i*i; j <n ; j+=i) {
                    //注意每次找当前素数 xxx 的倍数时，是从 x2x^2x2 开始的。
                    // 因为如果 x>2x > 2x>2，那么 2∗x2*x2∗x 肯定被素数 2 给过滤了，最小未被过滤的肯定是 x2x^2x2。
                   //这里很重要 开始筛选的是i*i个 如果i为3就从9开始 因为6肯定被2筛选了
                    //如果为5就从25开始 5*2 5*3 都被2 和 3 筛选了，所以从比5大的开始筛
                    nums[j]=false;
                }
            }
        }
        int count=0;
        for (int i = 2; i < n; i++) {
            if(nums[i])
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1));
    }
}