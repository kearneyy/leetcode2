package _7整数反转;

//技巧，用逆操作来判断溢出
public class Solution3 {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
          int newans = ans*10+x%10;
          if((newans-(x%10))/10!=ans)
              return 0;
          ans=newans;
          x=x/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
