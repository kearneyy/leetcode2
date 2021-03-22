package _202克隆图;

import java.util.*;

/**
 * 133. 克隆图
 * 难度
 * 中等
 * 202
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 */

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//错误写法，只是复制的节点的val，但是地址不一样
class Solution {
    public static Node cloneGraph(Node node) {
        Node mynode = new Node(node.val);
        List<Node> mylist = new ArrayList<Node>();
        Queue<Node> queue = new ArrayDeque<>();
        Map<Integer,Boolean> map = new HashMap<>();
        map.put(node.val,true);
        for (Node neighbor : node.neighbors) {
            mylist.add(neighbor);
            queue.add(neighbor);
            map.put(neighbor.val,true);
        }
        mynode.neighbors=mylist;
        while(!queue.isEmpty())
        {
            Node poll = queue.poll();
            Node newnode = new Node();
            newnode.val=poll.val;
            List<Node> neighbors = poll.neighbors;
            List<Node> newlist = new ArrayList<>();
            for (Node neighbor : neighbors) {
                newlist.add(neighbor);
                if(!map.containsKey(neighbor.val))
                {
                    map.put(neighbor.val,true);
                    queue.add(neighbor);
                }
            }
            newnode.neighbors=newlist;
        }
        return mynode;
    }

    public static void main(String[] args) {
        Node node1  =new Node(1);
        Node node2  =new Node(2);
        Node node3  =new Node(3);
        Node node4  =new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node4);
        node1.neighbors=list1;
        List<Node> list2 = new ArrayList<>();
        list2.add(node1);
        list2.add(node3);
        node2.neighbors=list2;
        List<Node> list3 = new ArrayList<>();
        list3.add(node2);
        list3.add(node4);
        node3.neighbors=list3;
        List<Node> list4 = new ArrayList<>();
        list4.add(node1);
        list4.add(node3);
        node4.neighbors=list4;
        Node node = cloneGraph(node1);
        System.out.println(node);
        System.out.println(node.val);
    }
}