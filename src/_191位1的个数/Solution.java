package _191位1的个数;

public class Solution {
    public static int hammingWeight(int n) {
       int count = 0;
        for (int i = 0; i < 32; i++) {
            int num = (1<<i);
            if((n&num)!=0)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = hammingWeight(00000000000000000000000000001011);
        System.out.println(i);
        //011
        //111
        System.out.println(7&3);
        System.out.println(00000000000000000000000000001011&8);
    }
}

