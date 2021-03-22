package _491递增子序列;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    static List<Integer> temp = new ArrayList<Integer>();
    static Set<List<Integer>> ans = new HashSet<List<Integer>>();//也可以利用set的本身性质来去重，但是效率比较低

    public static List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return new ArrayList(ans);
    }

    public static void dfs(int cur,int last,int[] nums)
    {
        if(cur==nums.length)
        {
            if(temp.size()>1)
                ans.add(new ArrayList<>(temp));
                return;
        }
        if(nums[cur]>=last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
            dfs(cur+1,last,nums);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = findSubsequences(new int[]{4,6,7,7});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
