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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

//自己写的 利用set但是
//[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]不通过
//因为存在两个TIA ANU而SET只能存一个
class Solution {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String,TreeSet<String>> map = new HashMap<String,TreeSet<String>>();
        for(List lists:tickets)
        {
            if(!map.containsKey(lists.get(0)))
            {
                TreeSet set = new TreeSet();
                set.add(lists.get(1));
                map.put((String) lists.get(0), set);
            }
            else
            {
                TreeSet set = map.get(lists.get(0));
                set.add(lists.get(1));
            }
        }
        List<String> list = new ArrayList<String>();
        String point = "JFK";
        list.add(point);
        for (int i = 0; i < tickets.size(); i++) {
            TreeSet<String> treeset = map.get(point);
            point = treeset.first();
            if(!map.containsKey(point))
            {
                if(treeset.size()>1)
                {
                    String first = treeset.pollFirst();
                    point=treeset.first();
                    treeset.add(first);
                }
            }
            treeset.remove(point);
            list.add(point);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List list1 = new ArrayList<String>();
        List list2 = new ArrayList<String>();
        List list3 = new ArrayList<String>();
//        List list4 = new ArrayList<String>();
//        List list5 = new ArrayList<String>();
        list1.add("JFK");
        list1.add("KUL");
        list2.add("JFK");
        list2.add("NRT");
        list3.add("NRT");
        list3.add("JFK");
//        list4.add("ATL");
//        list4.add("JFK");
//        list5.add("ATL");
//        list5.add("SFO");
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
//        tickets.add(list4);
//        tickets.add(list5);
        System.out.println(findItinerary(tickets));
    }
}