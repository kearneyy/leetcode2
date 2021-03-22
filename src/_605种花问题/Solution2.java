package _605种花问题;

import java.util.Arrays;

//防御式编程 左右两边填0，方便遍历
class Solution2 {
    public  static boolean canPlaceFlowers(int[] flowerbed, int n) {
      int newflower[] = new int[flowerbed.length+2];
        for (int i = 1; i <newflower.length-1; i++) {
            newflower[i]=flowerbed[i-1];
        }
        for (int i = 1; i < newflower.length-1; i++) {
            if(newflower[i]==0&&newflower[i-1]==0&&newflower[i+1]==0)
            {
                newflower[i]=1;
                n--;
                if(n==0)
                    return true;
            }
        }
        return n<=0;
    }

    public static void main(String[] args) {
        boolean b = canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2);
        System.out.println(b);

    }
}