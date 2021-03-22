package _5602将x减到0的最小操作数;

//前缀和

import java.util.HashMap;
import java.util.Map;

//前面那个用数组存
//后面那个用map来存，这样方便查找o(1)
//然后依次遍历前面那个前缀 看和后面的后缀相加有没有等于x的
class Solution4 {
    public static int minOperations(int[] nums, int x) {
        int len = nums.length;
        //前缀和
        int[] preSum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        //后缀和
        Map<Integer, Integer> map = new HashMap<>();

        int[] latterSum = new int[len + 1];
        map.put(0,0);
        int idx = 1;
        for (int i = len - 1; i >= 0; i--) {
            latterSum[idx] = latterSum[idx-1] + nums[i];
            map.put(latterSum[idx],idx);
            idx++;
        }
        if (preSum[len] < x || latterSum[len] < x) return -1;//避免多次计算
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < len + 1; i++) {
            int pre = preSum[i];
            if (map.containsKey(x - pre)) {
                res = Math.min(res, map.get(x-pre)+i);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }


    public static void main(String[] args) {
        int nums[] = new int[]{3,2,20,1,1,3};
        int i = minOperations(nums, 5);
        System.out.println(i);
    }
}

