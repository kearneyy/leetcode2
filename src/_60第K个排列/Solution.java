package _60第K个排列;

/**
 * 60. 第k个排列
 * 难度
 * 中等
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 */
class Solution {
    static String str;
    static int count=0;
    static boolean flag=false;
    public static String getPermutation(int n, int k) {
        if(n==0)
            return "";
        boolean[] used = new boolean[n];
        StringBuilder sb =new StringBuilder();
        dfs(used,n,k,sb);
        return str;
    }

    private static void dfs(boolean[] used, int n, int k,StringBuilder sb)
    {
        if(!flag)
        {
            if(sb.length()==n)
            {
                count++;
                if(count==k) {
                    str = sb.toString();
                    flag=true;
                }
                return;
            }
            for (int i = 1; i <= n ; i++) {
                if(!used[i-1]&&!flag)
                {
                    used[i-1]=true;
                    sb.append(i);
                    dfs(used,n,k,sb);
                    sb.deleteCharAt(sb.length()-1);
                    used[i-1]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }
}