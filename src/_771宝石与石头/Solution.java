package _771宝石与石头;

/**
 * 771. 宝石与石头
 * 难度
 * 简单
 *
 * 576
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
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 */
class Solution {
    public static int numJewelsInStones(String J, String S) {
        int[] nums = new int['z'-'A'+1];
        for (int i = 0; i < J.length(); i++) {
            nums[J.charAt(i)-'A']++;
        }
        for (int i = 0; i < S.length(); i++) {
            if(nums[S.charAt(i)-'A']!=0)
            {
                nums[S.charAt(i)-'A']++;
            }
        }
        int total=0;
        for (int i = 0; i < nums.length; i++) {
            total+=nums[i];
        }
        return total-J.length();
    }

    public static void main(String[] args) {
        int num  =numJewelsInStones("z","ZZ");
        System.out.println(num);
    }
}