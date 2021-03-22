package _117填充每个节点的下一个右侧节点指针II;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 层次遍历
 */
public class Solution2 {
    public  Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int n = queue.size();
            Node last = null;
            for (int i = 0; i < n; i++) {
                Node f = queue.poll();
                if(f.left!=null)
                    queue.offer(f.left);
                if(f.right!=null)
                    queue.offer(f.right);
                if(i!=0)
                {
                    last.next=f;
                }
                last=f;
            }
        }
        return root;
    }
}
