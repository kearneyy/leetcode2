package _738单调递增的数字;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//32 29
// 250 2 49
class Solution {
    public static int monotoneIncreasingDigits(int N) {
        String num = String.valueOf(N);
         int nums[] = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i]=num.charAt(i)-'0';
        }
        boolean flag = true;
        while (flag)
        {
            int index=0;
            while (index<nums.length-1&&nums[index]<=nums[index+1])
            {
                index++;
            }
            if(index==nums.length-1)
            {
                flag=false;
            }
            else
            {
                nums[index]--;
                for (int i = index+1; i <nums.length; i++) {
                    nums[i]=9;
                }
            }
        }
        int total=0;
        int x=1;
        for (int i = nums.length-1; i >=0 ; i--) {
            total+=x*nums[i];
            x*=10;
        }
        return total;
    }

    public static void main(String[] args) {
        int i = monotoneIncreasingDigits(332);
        System.out.println(i);
    }
}