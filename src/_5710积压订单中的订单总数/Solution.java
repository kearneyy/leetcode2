package _5710积压订单中的订单总数;

import java.util.*;

/**
 * 给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。
 * <p>
 * 订单类型 orderTypei 可以分为两种：
 * <p>
 * 0 表示这是一批采购订单 buy
 * 1 表示这是一批销售订单 sell
 * <p>
 * 注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。
 * <p>
 * 存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：
 * <p>
 * 如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。否则，采购订单 buy 将会添加到积压订单中。
 * 反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。否则，销售订单 sell 将会添加到积压订单中。
 * <p>
 * 输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 109 + 7 取余的结果。
 */
class Solution {
    public static int getNumberOfBacklogOrders(int[][] orders) {
        Map<Integer, Integer> buymap = new HashMap<>();
        Map<Integer, Integer> sellmap = new HashMap<>();
        Queue<Integer> buyqueue = new PriorityQueue<>();
        Queue<Integer> sellqueue = new PriorityQueue<>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i][2] == 0) {
                if(buymap.containsKey(orders[i][0]))
                {
                    buymap.put(orders[i][0], orders[i][1]+buymap.get(orders[i][0]));
                }
                else
                {
                    buymap.put(orders[i][0],orders[i][1]);
                    buyqueue.add(-orders[i][0]);
                }


                while (!sellqueue.isEmpty() && sellqueue.peek() <= orders[i][0]) {
                    Integer integer = sellmap.get(sellqueue.peek());//剩余数量
                    if (integer < orders[i][1]) {
                        orders[i][1] -= integer;
                        sellmap.remove(sellqueue.poll());
                        buymap.put(orders[i][0],orders[i][1]);
                    } else if (integer == orders[i][1]) {
                        sellmap.remove(sellqueue.poll());
                        buymap.remove(orders[i][0]);
                        buyqueue.poll();
                        break;
                    } else {
                        sellmap.put(sellqueue.peek(), sellmap.get(sellqueue.peek()) - orders[i][1]);
                        buymap.remove(orders[i][0]);
                        buyqueue.poll();
                        break;
                    }

                }
            } else {
                if(sellmap.containsKey(orders[i][0]))
                {
                    sellmap.put(orders[i][0], orders[i][1]+sellmap.get(orders[i][0]));
                }
                else
                {
                    sellmap.put(orders[i][0], orders[i][1]);
                    sellqueue.add(orders[i][0]);
                }
                while (!buyqueue.isEmpty() && -buyqueue.peek() >= orders[i][0]) {
                    Integer integer = buymap.get(-buyqueue.peek());
                    if (integer < orders[i][1]) {
                        orders[i][1] -= integer;
                        buymap.remove(-buyqueue.poll());
                        sellmap.put(orders[i][0],orders[i][1]);
                    } else if (integer == orders[i][1]) {
                        buymap.remove(-buyqueue.poll());
                        sellmap.remove(orders[i][0]);
                        sellqueue.remove();
                        break;
                    } else {
                        buymap.put(-buyqueue.peek(), buymap.get(-buyqueue.peek()) - orders[i][1]);
                        sellmap.remove(orders[i][0]);
                        sellqueue.poll();
                        break;
                    }
                }

            }
        }
        long total = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : buymap.entrySet()) {
            total += integerIntegerEntry.getValue();
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : sellmap.entrySet()) {
            total += integerIntegerEntry.getValue();
        }
        return (int) (total % (1e9 + 7));
    }

    public static void main(String[] args) {
        int[][] orders = new int[][]
                {{1,29,1},{22,7,1},{24,1,0},{25,15,1},{18,8,1},{8,22,0},{25,15,1},{30,1,1},{27,30,0}};
        int numberOfBacklogOrders = getNumberOfBacklogOrders(orders);
        System.out.println(numberOfBacklogOrders);
    }
}