package _888公平的糖果棒交换;

import com.sun.corba.se.impl.oa.toa.TOA;

import javax.jnlp.SingleInstanceListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//效率太低
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = 0;
            for (int item : A) {
                sumA += item;
            }
            int sumB = 0;
            Set<Integer> setB = new HashSet<Integer>();
            for (int value : B) {
                sumB += value;
                setB.add(value);
            }
            int total = sumA + sumB;
            int mid = total / 2;
            int leftA = mid - sumA;
            for (int value : A) {
                if (setB.contains(leftA + value)) {
                    return new int[]{value, leftA + value};
                }
            }
            return new int[]{};
        }
    }