package _572另一个树的子树;


/**
 * 572. 另一个树的子树
 * 难度
 * 简单
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 */
class AnotherChildTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
       if(t==null)
           return true;
       if(s==null)
           return false;
        return isSubtree(s.left,t)||isSubtree(s.right,t)||isSameTree(s,t);

    }

    public boolean isSameTree(TreeNode s,TreeNode t){
        if(s==null&&t==null)//两个都为空就返回
            return true;
        if(s==null||t==null)//已经排除两个都为空的情况，如果有一个为空返回false
            return false;
        if(s.val!=t.val)
            return false;
        return isSameTree(s.left,t.left)&&isSameTree(s.right,t.right);
    }
}