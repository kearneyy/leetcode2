package _60第K个排列;

//考虑剪枝
//n个数的全排列有n!
//这个方法超快！
class Solution2 {
   private static boolean[] used;
   private static int[] factorial;
    public static String getPermutation(int n, int k) {
        if (n==0)
            return "";
        used = new boolean[n+1];
        calculateFactorial(n);
        StringBuilder sb = new StringBuilder();
        dfs(0,sb,n,k);
        return sb.toString();
    }

    private static void dfs(int index,StringBuilder sb,int n,int k)
    {
        if(index==n)
            return;
        int cur = factorial[n-1-index];
        for (int i = 1; i <= n ; i++) {
            if(used[i]) {
                continue;
            }
            if(cur<k)
            {
                k-=cur;
                continue;
            }
            used[i]=true;
            sb.append(i);
            dfs(index+1,sb,n,k);
            return;
        }

    }
    //计算阶乘
    private static void calculateFactorial(int n)
    {
        factorial = new int[n+1];
        factorial[0]=1;
        for (int i = 1; i <=n ; i++) {
            factorial[i]=i*factorial[i-1];
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }
}