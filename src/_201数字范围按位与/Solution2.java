package _201数字范围按位与;

//Brian Kernighan 算法
//n和n-1相与，去掉n最右边的1
class Solution2 {
    public static int rangeBitwiseAnd(int m, int n) {
      while(m<n)
      {
          n=n&(n-1);
      }
      return n;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
    }
}