package _283移动零;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void moveZeroes(int[] nums) {
        int zeronum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
            {
                zeronum++;
            }
            else
            {
                nums[i-zeronum]=nums[i];
            }
        }
        for (int i = nums.length-1; i >=nums.length-zeronum ; i--) {
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int num[] = new int[]{};
        moveZeroes(num);
        for (int i : num) {
            System.out.println(i);
        }
    }
}