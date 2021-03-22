package _332重新安排行程;

/**
 * 332. 重新安排行程
 * 难度
 * 中等
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * 说明:
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */

import java.util.*;

//自己写的 改成利用priortiye也不行
//[["EZE","TIA"],["EZE","HBA"],["AXA","TIA"],["JFK","AXA"],["ANU","JFK"],["ADL","ANU"],["TIA","AUA"],["ANU","AUA"],["ADL","EZE"],["ADL","EZE"],["EZE","ADL"],["AXA","EZE"],["AUA","AXA"],["JFK","AXA"],["AXA","AUA"],["AUA","ADL"],["ANU","EZE"],["TIA","ADL"],["EZE","ANU"],["AUA","ANU"]]不通过

class Solution3 {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> map = new HashMap<String,PriorityQueue<String>>();
        for(List lists:tickets)
        {
            if(!map.containsKey(lists.get(0)))
            {
                PriorityQueue queue = new PriorityQueue();
                queue.add(lists.get(1));
                map.put((String) lists.get(0), queue);
            }
            else
            {
                PriorityQueue queue = map.get(lists.get(0));
                queue.add(lists.get(1));
            }
        }
        List<String> list = new ArrayList<String>();
        String point = "JFK";
        list.add(point);
        for (int i = 0; i < tickets.size(); i++) {
            PriorityQueue<String> queue = map.get(point);
            point = queue.peek();
            if(!map.containsKey(point)||map.get(point).size()==0)
            {
                if(queue.size()>1)
                {
                    String first = point;
                    queue.remove(first);
                    point=queue.peek();
                    queue.add(first);
                }
            }
            queue.remove(point);
            list.add(point);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List list1 = new ArrayList<String>();
        List list2 = new ArrayList<String>();
        List list3 = new ArrayList<String>();
        List list4 = new ArrayList<String>();
        List list5 = new ArrayList<String>();
        List list6 = new ArrayList<String>();
        List list7 = new ArrayList<String>();
        List list8 = new ArrayList<String>();
        List list9 = new ArrayList<String>();
        List list10 = new ArrayList<String>();
        //[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
        list1.add("EZE");
        list1.add("AXA");
        list2.add("TIA");
        list2.add("ANU");
        list3.add("ANU");
        list3.add("JFK");
        list4.add("JFK");
        list4.add("ANU");
        list5.add("ANU");
        list5.add("EZE");
        list6.add("TIA");
        list6.add("ANU");
        list7.add("AXA");
        list7.add("TIA");
        list8.add("TIA");
        list8.add("JFK");
        list9.add("ANU");
        list9.add("TIA");
        list10.add("JFK");
        list10.add("TIA");
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
        tickets.add(list4);
        tickets.add(list5);
        tickets.add(list6);
        tickets.add(list7);
        tickets.add(list8);
        tickets.add(list9);
        tickets.add(list10);
        System.out.println(findItinerary(tickets));
    }
}