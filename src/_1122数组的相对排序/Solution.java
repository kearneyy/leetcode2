package _1122数组的相对排序;

import jdk.management.resource.internal.inst.WindowsAsynchronousFileChannelImplRMHooks;

import java.util.*;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 *
 * 	arr2 中的元素各不相同
 * 	arr2 中的每个元素都出现在 arr1 中
 *
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int arr[] = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }
        int num[] = new int[arr1.length];
        int index=0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr[arr2[i]]; j++) {
                num[index++]=arr2[i];
            }
            arr[arr2[i]]=0;
        }
        int leftnum[] = new int[arr1.length-index];
        int index2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr[arr1[i]]!=0)
            {
                leftnum[index2++]=arr1[i];
            }
        }
        Arrays.sort(leftnum);
        for (int i = 0; i <leftnum.length ; i++) {
            num[index++]=leftnum[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{28,6,22,8,44,17};
        int arr2[] = new int[]{22,28,8,6};
        int[] ints = relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}