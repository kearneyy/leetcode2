package _703数据流中的第K大元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 703. 数据流中的第 K 大元素
 * 难度
 * 简单
 *
 * 194
 *
 *
 *
 *
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */

//二分插入  效率低
class KthLargest {
    int k;
    List<Integer> list;
    int len;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        len = nums.length;
    }

    public int add(int val) {
        int low=0,high=len-1;
        int middle = 0;
        if(len==0)
            list.add(val);
        while(low <= high)
        {
            middle = (low + high)/2;
            if(list.get(middle) > val)
            {
                //插入位置在data[middle]之前
                high= middle-1;
                if(high < low)
                {
                    list.add(low,val);
                    break;
                }
                else if(list.get(high) <= val)
                {
                    list.add(high+1,val);
                    break;
                }
            }
            else if(list.get(middle)<val)
            {
                //插入位置在data[middle]之后
                low = middle +1;
                if(high<low)
                {
                    list.add(low,val);
                    break;
                }
                else if(list.get(low) >= val)
                {
                    list.add(low,val);
                    break;
                }
            }
            else
            {
                list.add(middle+1,val);
                break;
            }
        }
        len++;
        return list.get(len-k);
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(1,new int[]{});
        kthLargest.add(-3);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(0);
        kthLargest.add(4);
        List<Integer> list = kthLargest.list;
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */