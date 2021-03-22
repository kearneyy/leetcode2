package 剑指offer11旋转数组的最小数字;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
//二分法
//查找最小的哪个数字 左边都比他大 右边都比他小
class Solution {
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(numbers[high]>numbers[mid])
            {
                high=mid;//因为是找最小值，如果high=mid-1可能会变成最大值而错过
            }
            else if(numbers[high]<numbers[mid])
            {
                low=mid+1;//最大值往左移一位可能是最小值
            }
            else
            {
                high=high-1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{3,1,3}));
    }
}