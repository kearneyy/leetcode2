package _167两数之和2;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
//解法1，双指针
class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        do{
            int num1 = numbers[left];
            int num2 = numbers[right];
            int num = target-num2;
            if(num>num1)
            {
                left++;
            }
            else if(num<num1)
            {
                right--;
            }
            else
            {
                break;
            }
        }while(left<right);
            return new int[]{left+1,right+1};
    }

    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int[] index = twoSum(num,18);
        for (int i : index) {
            System.out.println(i);
        }
    }
}