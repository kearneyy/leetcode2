package _5563销售价值减少的颜色球;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 你有一些球的库存 inventory ，里面包含着不同颜色的球。一个顾客想要 任意颜色 总数为 orders 的球。
 * 这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的 同色球 的数目。比方说还剩下 6 个黄球，那么
 * 顾客买第一个黄球的时候该黄球的价值为 6 。这笔交易以后，只剩下 5 个黄球了，所以下一个黄球的价值为 5 （也就是球的价值随着顾客购买同色球是递减的）
 * 给你整数数组 inventory ，其中 inventory[i] 表示第 i 种颜色球一开始的数目。同时给你整数 orders ，表示
 * 顾客总共想买的球数目。你可以按照 任意顺序 卖球。
 * 请你返回卖了 orders 个球以后 最大 总价值之和。由于答案可能会很大，请你返回答案对 109 + 7 取余数 的结果。
 * 输入：inventory = [2,5], orders = 4
 * 输出：14
 * 解释：卖 1 个第一种颜色的球（价值为 2 )，卖 3 个第二种颜色的球（价值为 5 + 4 + 3）。
 * 最大总和为 2 + 5 + 4 + 3 = 14 。
 * 示例 2：
 * 输入：inventory = [3,5], orders = 6
 * 输出：19
 * 解释：卖 2 个第一种颜色的球（价值为 3 + 2），卖 4 个第二种颜色的球（价值为 5 + 4 + 3 + 2）。
 * 最大总和为 3 + 2 + 5 + 4 + 3 + 2 = 19 。
 * 示例 3：
 * 输入：inventory = [2,8,4,10,6], orders = 20
 * 输出：110
 * 示例 4：
 * 输入：inventory = [1000000000], orders = 1000000000
 * 输出：21
 * 解释：卖 1000000000 次第一种颜色的球，总价值为 500000000500000000 。 500000000500000000 对 109 + 7 取余为 21 。
 */

//过了14个用例 不知道错哪儿了
class Solution3 {
    static long mod = (long)1e9 + 7;//e的用法
    public static int maxProfit(int[] inventory, int orders) {
        if(inventory.length==0)
            return 0;
        if(inventory.length==1)
        {
            long temp = inventory[0]-orders;
            long total = (getNum(temp+1,inventory[0])%mod);
            return (int) total;
        }
        Arrays.sort(inventory);
        int temp[] = new int[inventory.length];
        for (int i = 0; i < inventory.length; i++) {
            temp[i]=inventory[i];
        }
        int nextminindex=temp.length-1;
        while (!(temp[1]==temp[0])&&orders!=0)
        {
            int nextmin=temp[temp.length-1];

            for (int i = nextminindex; i >=0; i--) {
                if(temp[i]<nextmin)
                {
                    nextmin=temp[i];
                    nextminindex=i;
                    break;
                }
            }
            for (int i = temp.length-1; i >=0 ; i--) {
                if(temp[i]-nextmin<=orders)
                {
                    if(temp[i]==nextmin)
                        break;
                    orders-=temp[i]-nextmin;
                    temp[i]=nextmin;
                }
                else
                {
                    temp[i]=temp[i]-orders;
                    orders=0;
                    break;
                }
            }
        }
        while(orders!=0)
        {
            for (int i = 0; i < inventory.length; i++) {
                temp[i]--;
                orders--;
                if(orders==0)
                    break;
            }
        }
        long total=0;
        for (int i = 0; i < inventory.length; i++) {
            total+=getNum(temp[i]+1,inventory[i]);
        }
        total=total%mod;
        return (int)total;
    }

    public static  long getNum(long a,long b)//这里不能用int
    {
        return (a+b)*(b-a+1)/2;
    }

    public static void main(String[] args) {
        int[] num = new int[]{497978859,167261111,483575207,591815159};
        int i = maxProfit(num, 836556809
        );
        System.out.println(i);
    }
}