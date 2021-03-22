package _5710积压订单中的订单总数;

import sun.reflect.generics.tree.Tree;

import java.util.*;

//别人的做法 直接构造的时候传入Comparator就好了
class Solution2 {
    public static int getNumberOfBacklogOrders(int[][] orders) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        };
        Comparator<int[]> comparator2 = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        };

        PriorityQueue<int[]> BuyQ = new PriorityQueue<>(comparator); //<价格, 数目>，大顶堆
        PriorityQueue<int[]> SellQ = new PriorityQueue<>(comparator2);  //<价格, 数目>，小顶堆
        for (int[] order : orders) {
            if (order[2] == 0) {   //当前订单是Buy，需要找最小的Sell
                while (order[1] > 0 && !SellQ.isEmpty() && SellQ.peek()[0] <= order[0]) {  //当前订单数目大于0，Sell最低价<= 当前订单价格
                    if (order[1] > SellQ.peek()[1]) {  //当前订单数 > Sell最低价的订单数
                        order[1] -= SellQ.poll()[1];  //Sell中最低价被删除
                    } else if (order[1] == SellQ.peek()[1]) {  //当前订单数 == Sell最低价的订单数
                        SellQ.poll();  //Sell中最低价被删除
                        order[1] = 0;
                    } else if (order[1] < SellQ.peek()[1]) { //当前订单数 < Sell最低价的订单数
                        int[] minSell = SellQ.poll(); //更新Sell最低价的订单数量
                        SellQ.add(new int[] {minSell[0], minSell[1] - order[1]});
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) BuyQ.add(new int[] {order[0], order[1]});//当前订单数还有余留，则压入队列中
            } else {  //当前订单是Sell，需要找最大的Buy
                while (order[1] > 0 && !BuyQ.isEmpty() && BuyQ.peek()[0] >= order[0]) {  //当前订单数目大于0，Buy最高价>= 当前订单价格
                    if (order[1] > BuyQ.peek()[1]) {  //当前订单数 > Buy最高价的订单数
                        order[1] -= BuyQ.poll()[1];  //Buy最高价被删除
                    } else if (order[1] == BuyQ.peek()[1]) {  //当前订单数 == Buy最高价的订单数
                        BuyQ.poll();  //Buy最高价被删除
                        order[1] = 0;
                    } else if (order[1] < BuyQ.peek()[1]) { //当前订单数 < Buy最高价的订单数
                        int[] maxBuy = BuyQ.poll(); //更新Buy最高价的订单数量
                        BuyQ.add(new int[] {maxBuy[0], maxBuy[1] - order[1]});
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) SellQ.add(new int[] {order[0], order[1]});//当前订单数还有余留，则压入队列中
            }
        }
        int res = 0;
        while (!BuyQ.isEmpty()) {
            res = (res + BuyQ.poll()[1]) % 1000000007;
        }
        while (!SellQ.isEmpty()) {
            res = (res + SellQ.poll()[1]) % 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] orders = new int[][]
                {{1,29,1},{22,7,1},{24,1,0},{25,15,1},{18,8,1},{8,22,0},{25,15,1},{30,1,1},{27,30,0}};
        int numberOfBacklogOrders = getNumberOfBacklogOrders(orders);
        System.out.println(numberOfBacklogOrders);
    }
}
