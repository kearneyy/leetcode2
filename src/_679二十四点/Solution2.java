package _679二十四点;

/**
 *
 * 只有 4 张牌，且只能执行 4 种操作。
 *
 *
 * 即使所有运算符都不进行交换，最多也只有 12 * 4 * 6 * 4 * 2 * 4 = 9216。
 *
 * 具体来说，我们有 12 种方式先选出两个数字（有序），并执行 4 种操作之一（12 * 4）。
 *
 * 然后，剩下 3 个数字，我们从中选择 2 个并执行 4 种操作之一（6 * 4）。
 *
 *
 * 最后我们剩下两个数字，并在 2 * 4 种可能之中作出最终选择。
 *
 *
 *
 * 我们将对我们的数字或结果数字执行 3 次二元运算（+，-，*，/ 是运算）。
 *
 *
 * 因为 - 和 / 不满足交换律，我们必须仔细考虑 a / b 和 b / a。
 *
 *
 * 对于在我们的列表中移除 a, b 这两个数字的每一种方法，以及它们可能产生的每种结果，如 a + b、a / b等，我们将采用递归的方法解决这个较小的数字列表上的问题。
 *
 *
 * 以上都考虑全排列的结果，每次选择都考虑顺序的不同在除法和减法时候的不同，乘法和加法不影响。
 *
 * 作者：wo-zi-heng-dao-xiang-tian-xiao
 * 链接：https://leetcode-cn.com/problems/24-game/solution/leetcode-679-24-dian-you-xi-by-wo-zi-heng-dao-xian/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 第 3~7 行采用一个 double 数组来替代输入的 int 数组，原因有二：
 *
 * 首先，采用数组操作性能会更好，实测假如改成 ArrayList 容易超时。
 * 其次，采用 double 可以避免整数除法问题的出现，使得结果更为精确，不出错。
 *
 *
 * 第 13~15 行是递归的终止条件，当结果数组里面剩余一个值，我们判断其与 24 的差值，由于计算机采用近似计算，只要差值小于一定范围即认为是精确值，此处采用 0.001，也可以使用 0.0001 等，足够小即可。
 * 第 17~18 行的两个 for 循环的目的是从四个数里面选出两个不同的数进行第一波运算（加减乘除）。
 * 第 19 行新建了一个 double 数组来存储第一波运算后留下的三个值。
 * 第 21~25 行表示将第一波没有选出来的两个数存到第二波计算的数组中。
 * 第 27~32 行的意思是将第一波运算得出的每一个值都存一次到第二波计算的数组中，然后进行递归第二、第三波运算，假如其中有一次运算结果符合要求，则直接返回 true。
 * 第 40~42 行表示每一波进行的四则运算过程。
 *
 * 作者：wo-zi-heng-dao-xiang-tian-xiao
 * 链接：https://leetcode-cn.com/problems/24-game/solution/leetcode-679-24-dian-you-xi-by-wo-zi-heng-dao-xian/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 {
    public static boolean judgePoint24(int[] nums) {
        double[] nums_2 = new double[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nums_2[i] = nums[i];
        }

        return dfs(nums_2);
    }

    private static boolean dfs(double[] nums_2) {
        if (nums_2.length == 1) {
            return Math.abs(nums_2[0] - 24.0) < 0.001;
        }

        for (int i = 0; i < nums_2.length; i++) {
            for (int j = i + 1; j < nums_2.length; j++) {
                double[] nums_3 = new double[nums_2.length - 1];

                for (int k = 0, index = 0; k < nums_2.length; k++) {
                    if (k != i && k != j) {
                        nums_3[index++] = nums_2[k];
                    }
                }

                for (double r : compute(nums_2[i], nums_2[j])) {
                    nums_3[nums_3.length - 1] = r;

                    if (dfs(nums_3)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static double[] compute(double i, double j) {
        return new double[]{i + j, i - j, j - i, i * j, i / j, j / i};
    }

    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{1,2,1,2}));
    }
}
