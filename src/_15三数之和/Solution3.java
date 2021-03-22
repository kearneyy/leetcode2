package _15三数之和;

import java.util.*;

/**
 * 15. 三数之和
 * 难度
 * 中等
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 *
 * 老方法会超时,为什么不用回溯呢，因为这个是固定3个值，然后老方法是传递了k，更灵活，而且有的时候答案是可变长度，
 * 相对来说回溯的话要花更久的时间
 */
class Solution3 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length==0)
            return lists;
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(set,path,0,0,nums);
        lists.addAll(set);
        return lists;
    }

    public static void dfs(Set<List<Integer>> set,Deque<Integer> path,int begin,int sum,int[] nums){
        if(path.size()==3)
        {
            if(sum==0) {
                set.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i <nums.length ; i++) {
            if(sum+nums[i]>0)
            {
                break;
            }
            path.add(nums[i]);
            dfs(set,path,i+1,sum+nums[i],nums);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,4});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}