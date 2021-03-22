package _5563销售价值减少的颜色球;

import java.util.Arrays;

//别人写的
class Solution2 {
    public static int maxProfit(int[] inv, int orders) {
        Arrays.sort(inv);
        int n = inv.length;
        long ans = 0;
        for(int i = n - 1; i >= 0 && orders > 0; i--){
            int l = i;
            while(l > 0 && inv[l] == inv[l - 1]){
                l--;
            }
            int cnt = n - l;
            int use = l == 0 ? inv[l] : inv[l] - inv[l - 1];
            if((long)use * cnt >= orders){
                int left = inv[l] - orders / cnt;
                ans += sum(left + 1, inv[l]) * cnt;
                ans += (long)left * (orders % cnt);
                orders = 0;
            }else{
                ans += sum(inv[l - 1] + 1, inv[l]) * cnt;
                orders -= (int)(use * cnt);
            }
            i = l;
        }
        int mod = (int)1e9 + 7;
        return (int)(ans % mod);
    }

    public static long sum(long l, long r){
        return (l + r) * (r - l + 1) / 2;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1000000000
        };
        int i = maxProfit(num, 1000000000
        );
        System.out.println(i);
    }
}