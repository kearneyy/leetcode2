package _350两个数组的交集II;

import java.util.Arrays;
import java.util.HashMap;

//利用hashmap，记录数字和出现的次数,先遍历第一个数组，再遍历第二个数组，遍历第二个的时候如果有一个就把value-1
class Solution2{
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] number = new int[Math.min(nums1.length, nums2.length)];
        int index=0;
        for (int num : nums1) {
            if(map.containsKey(num))
            {
                Integer integer = map.get(num);
                Integer count = integer+1;
                map.put(num,count);
            }
            else{
                map.put(num,1);
            }
        }
        for (int num:nums2)
        {
            if((map.containsKey(num))&&(map.get(num)!=0))
            {
                number[index]=num;
                index++;
                Integer integer = map.get(num);
                Integer count = integer-1;
                map.put(num,count);
            }
        }
        return Arrays.copyOfRange(number,0,index);
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,4,3,4};
        int[] b = {1,2,4,4,5};
        int[] intersect = intersect(a, b);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}