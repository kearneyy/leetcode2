package _9回文数;

//判断每一位,这个更慢
public class Solution2 {
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x<10)
            return true;
        if(x%10==0)
            return false;
        int num=x;
        int dev=1;
        while(num/dev>=10){
            dev*=10;
        }
        while(num!=0)
        {
            int left=num/dev;
            int right = num%10;
            if(left!=right)
                return false;
            num=(num-left*dev)/10;
            dev/=100;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
}
