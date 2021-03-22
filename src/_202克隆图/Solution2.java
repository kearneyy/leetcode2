package _202克隆图;

import java.util.*;

/**
 * 133. 克隆图
 * 难度
 * 中等
 * 202
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p>
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 */

//思路：广度优先遍历，把节点存入一个map中
class Solution2 {
    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;
        //先构造一个要返回的节点（头节点）
        Node mynode = new Node(node.val);
        List<Node> mylist = new ArrayList<Node>();
        Queue<Node> queue = new ArrayDeque<>();
        Map<Integer, Node> map = new HashMap<>();//map的key为val，value为节点
        map.put(node.val, mynode);
        for (Node neighbor : node.neighbors) {
            Node tempnode = new Node(neighbor.val);
            mylist.add(tempnode);
            queue.add(neighbor);
            map.put(neighbor.val, tempnode);
        }
        mynode.neighbors = mylist;
        while (!queue.isEmpty())//广度优先遍历
        {
            Node poll = queue.poll();
            Node newnode = map.containsKey(poll.val) ? map.get(poll.val) : new Node(poll.val);//要改动的节点，如果之前建立过就调用hashmap的value，没有就创建一个
            List<Node> neighbors = poll.neighbors;
            List<Node> newlist = map.containsKey(poll.val) ? newnode.neighbors : new ArrayList<>();//要改动的节点list，如果之前建立过就调用hashmap的value，没有就创建一个
            for (Node neighbor : neighbors) {
                if (!map.containsKey(neighbor.val))//如果当前节点没在map中
                {
                    Node tempnode = new Node(neighbor.val); //创建新节点
                    newlist.add(tempnode);
                    map.put(neighbor.val, tempnode);
                    queue.add(neighbor);
                } else {
                    newlist.add(map.get(neighbor.val));
                }
            }
            newnode.neighbors = newlist;
        }
        return mynode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node4);
        node1.neighbors = list1;
        List<Node> list2 = new ArrayList<>();
        list2.add(node1);
        list2.add(node3);
        node2.neighbors = list2;
        List<Node> list3 = new ArrayList<>();
        list3.add(node2);
        list3.add(node4);
        node3.neighbors = list3;
        List<Node> list4 = new ArrayList<>();
        list4.add(node1);
        list4.add(node3);
        node4.neighbors = list4;
        Node node = cloneGraph(node1);
        System.out.println(node);
        System.out.println(node.val);
    }
}