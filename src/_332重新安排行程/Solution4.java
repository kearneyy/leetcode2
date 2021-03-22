package _332重新安排行程;

import java.util.*;

/**
 * 自己仿造
 */
public class Solution4 {
    static List<String> list = new ArrayList<String>();
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for (List lists : tickets) {
            if (!map.containsKey(lists.get(0))) {
                PriorityQueue queue = new PriorityQueue();
                queue.add(lists.get(1));
                map.put((String) lists.get(0), queue);
            } else {
                PriorityQueue queue = map.get(lists.get(0));
                queue.add(lists.get(1));
            }
        }

        dfs("JFK",map);
        Collections.reverse(list);
        return list;
    }

    public static void dfs(String curr,Map<String, PriorityQueue<String>> map)
    {
        while(map.containsKey(curr)&&map.get(curr).size()>0)
        {
            String poll = map.get(curr).poll();
            dfs(poll,map);
        }
        list.add(curr);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List list1 = new ArrayList<String>();
        List list2 = new ArrayList<String>();
        List list3 = new ArrayList<String>();
//        List list4 = new ArrayList<String>();
//        List list5 = new ArrayList<String>();
//        List list6 = new ArrayList<String>();
//        List list7 = new ArrayList<String>();
//        List list8 = new ArrayList<String>();
//        List list9 = new ArrayList<String>();
//        List list10 = new ArrayList<String>();
        //[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
        list1.add("JFK");
        list1.add("KUL");
        list2.add("JFK");
        list2.add("NRT");
        list3.add("NRT");
        list3.add("JFK");
//        list4.add("JFK");
//        list4.add("ANU");
//        list5.add("ANU");
//        list5.add("EZE");
//        list6.add("TIA");
//        list6.add("ANU");
//        list7.add("AXA");
//        list7.add("TIA");
//        list8.add("TIA");
//        list8.add("JFK");
//        list9.add("ANU");
//        list9.add("TIA");
//        list10.add("JFK");
//        list10.add("TIA");
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
//        tickets.add(list4);
//        tickets.add(list5);
//        tickets.add(list6);
//        tickets.add(list7);
//        tickets.add(list8);
//        tickets.add(list9);
//        tickets.add(list10);
        System.out.println(findItinerary(tickets));
    }
}
