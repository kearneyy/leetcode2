package _679二十四点;

/**
 * 679. 24 点游戏
 * 难度
 * 困难
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * 示例 1:
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 注意:
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 */
class Solution {
    public static boolean judgePoint24(int[] nums) {
        int len = nums.length;
        double[] nums2 = new double[len];
        for (int i = 0; i < len; i++) {
            nums2[i]=nums[i];
        }
        return dfs(nums2);
    }

    public static boolean dfs(double[] nums2)
    {
        if(nums2.length==1)
        {
            return Math.abs(nums2[0]-24.0)<0.001;
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i+1; j < nums2.length; j++) {
                double[] nums3 = new double[nums2.length-1];
                for (int k = 0,index=0; k < nums2.length; k++) {
                    if(k!=i&&k!=j)
                    {
                        nums3[index++]=nums2[k];
                    }
                }
                double[] compile = compile(nums2[i], nums2[j]);
                for (double c : compile) {
                    nums3[nums3.length-1]=c;
                    if(dfs(nums3))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //这里是递归地把数组不断缩小，到最后为1的时候返回，每一次递归都会构造一个更小的double数组，直到if有一个为24就直接return true，如过到后面一个都没有return false

    public static double[] compile(double i,double j)
    {
        return new double[]{i+j,i-j,j-i,i*j,i/j,j/i};
    }

    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{1,2,1,2}));
    }
}