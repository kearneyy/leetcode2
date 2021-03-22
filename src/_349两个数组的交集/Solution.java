package _349两个数组的交集;

import javax.jnlp.ClipboardService;
import java.util.*;

/**
 * 349. 两个数组的交集
 * 难度
 * 简单
 *
 * 244
 *
 *
 *
 *
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]))
            {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int nums[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i]=list.get(i);
        }
        return nums;
    }
}