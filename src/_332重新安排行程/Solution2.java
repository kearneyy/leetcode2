package _332重新安排行程;

//官方

import java.util.*;

/**
 * Hierholzer
 * 思路及算法
 * Hierholzer\text{Hierholzer}Hierholzer 算法用于在连通图中寻找欧拉路径，其流程如下：
 * 从起点出发，进行深度优先搜索。
 * 每次沿着某条边从某个顶点移动到另外一个顶点的时候，都需要删除这条边。

 * 如果没有可移动的路径，则将所在节点加入到栈中，并返回。

 * 当我们顺序地考虑该问题时，我们也许很难解决该问题，因为我们无法判断当前节点的哪一个分支是「死胡同」分支。
 * 不妨倒过来思考。我们注意到只有那个入度与出度差为 111 的节点会导致死胡同。而该节点必然是最后一个遍历到的节点。我们可以改变入栈的规则，当我们遍历完一个节点所连的所有节点后，我们才将该节点入栈（即逆序入栈）。
 * 对于当前节点而言，从它的每一个非「死胡同」分支出发进行深度优先搜索，都将会搜回到当前节点。而从它的「死胡同」分支出发进行深度优先搜索将不会搜回到当前节点。也就是说当前节点的死胡同分支将会优先于其他非「死胡同」分支入栈。
 * 这样就能保证我们可以「一笔画」地走完所有边，最终的栈中逆序地保存了「一笔画」的结果。我们只要将栈中的内容反转，即可得到答案。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary/solution/zhong-xin-an-pai-xing-cheng-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 {
    static Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    static List<String> itinerary = new LinkedList<String>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        int count=0;
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public static void dfs(String curr) {

        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }

        itinerary.add(curr);
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
