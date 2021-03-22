package _202克隆图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//官方，深度优先遍历
class Solution3 {
    private Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        if(visited.containsKey(node))
        {
            return visited.get(node);
        }
        Node clonenode = new Node(node.val,new ArrayList<>());
        visited.put(node,clonenode);
        for (Node neighbor : node.neighbors) {
            clonenode.neighbors.add(cloneGraph(neighbor));
        }
        return clonenode;
    }
}

