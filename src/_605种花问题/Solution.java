package _605种花问题;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0)
            return true;
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==1)
            {
                flag=true;
                break;
            }
            index++;
        }
        if(!flag)
        {
            n--;
            index=0;
        }
        else {
            n-=index/2;
        }

        int count=0;
        for (int i = index+1; i <flowerbed.length; i++) {
            if(n==0)
                return true;
            if(flowerbed[i]==1)
            {
                count=0;
            }
            else
            {
                count++;
                if(count>=2)
                {
                    if(i<flowerbed.length-1&&flowerbed[i+1]==0)
                    {
                        count=0;
                        n--;
                        if(n==0)
                            return true;
                    }
                    if(i==flowerbed.length-1)
                        n--;
                    if(n==0)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = canPlaceFlowers(new int[]{0}, 1);
        System.out.println(b);
    }
}