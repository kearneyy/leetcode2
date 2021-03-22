package Test;

import java.util.ArrayList;
import java.util.List;

public class DZTest {
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static List<Integer> temp = new ArrayList<Integer>();
    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            // 判断是否合法，如果合法判断是否重复，将满足条件的加入答案
                ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 如果选择当前元素
        temp.add(nums[cur]);
        dfs(cur + 1, nums);
        temp.remove(temp.size() - 1);
        // 如果不选择当前元素
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        dfs(0,new int[]{1,2,3,4});
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

}
