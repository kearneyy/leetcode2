package _337打家劫舍三;

//递归+记忆化

import java.util.HashMap;

/**
 * 我们这一步针对重复子问题进行优化，我们在做斐波那契数列时，使用的优化方案是记忆化，但是之前的问题都是
 * 使用数组解决的，把每次计算的结果都存起来，下次如果再来计算，就从缓存中取，不再计算了，这样就保证每个数字只计算一次。
 * 由于二叉树不适合拿数组当缓存，我们这次使用哈希表来存储结果，TreeNode 当做 key，能偷的钱当做 value
 *
 * 作者：reals
 * 链接：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

//递归+记忆化，用一个map来记忆，重复遍历的时候返回
public class Solution3 {
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> memo = new HashMap<>();
        return robInteval(root,memo);
    }

    public int robInteval(TreeNode node,HashMap<TreeNode,Integer> map)
    {
        if(node==null)
            return 0;
        if(map.containsKey(node))
            return map.get(node);
        int money = node.val;
        if(node.left!=null)
        {
           money+=(robInteval(node.left.left,map)+robInteval(node.left.right,map));
        }
        if(node.right!=null)
        {
            money+=(robInteval(node.right.left,map)+robInteval(node.right.right,map));
        }
        int result = Math.max(money,robInteval(node.left,map)+robInteval(node.right,map));
        map.put(node,result);
        return result;
    }
}
