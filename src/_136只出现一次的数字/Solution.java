package _136只出现一次的数字;

/**
 * 136. 只出现一次的数字
 * 难度
 * 简单
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 利用异或，0与一个数异或是他本身，两个相同数异或为0；
 */
class Solution {
    public int singleNumber(int[] nums) {
        int num=0;
        for (int i : nums) {
            num^=i;
        }
        return num;
    }
}