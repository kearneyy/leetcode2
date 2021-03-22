package _560和为K的子数组;

import java.util.HashMap;

/**
 * 用前缀和+hashmap
 */
public class Solution3 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        int pre=0;
        map.put(0,1);
        for (int i=0;i<nums.length;i++)
        {
            pre+=nums[i];//pre每过一个数字加1
            if(map.containsKey(pre-k))
            {
                count+=map.get(pre-k);//count增加的值为pre-k对应key的下标
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
            //如果pre存在，pre的值为++，如果不存在，pre的值为1
        }
        return count;
    }

}
