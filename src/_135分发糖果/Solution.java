package _135分发糖果;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 	每个孩子至少分配到 1 个糖果。
 * 	相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//典型的贪心
class Solution {
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int left[] = new int[len];
        int right[] = new int[len];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < len; i++) {
            if(ratings[i]>ratings[i-1])
            {
                left[i]=left[i-1]+1;
            }
        }
        for (int i = len-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1])
            {
                right[i]=right[i+1]+1;
            }
        }
        int num[] = new int[len];
        for (int i = 0; i < len; i++) {
            num[i]= Math.max(left[i],right[i]);
        }
        int total=0;
        for (int i = 0; i < len; i++) {
            total+=num[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int candy = candy(new int[]{1, 0, 2});
        System.out.println(candy);
    }
}