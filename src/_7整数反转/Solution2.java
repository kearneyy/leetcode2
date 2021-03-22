package _7整数反转;

//标准解法
class Solution2 {
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;//这里余数是带符号的
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))//正数溢出的最后一位为7
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))//负数溢出的最后一位为8
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-5%3);
        System.out.println(-5%-3);
        System.out.println(5%-3);
    }
}
