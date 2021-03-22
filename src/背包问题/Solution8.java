package 背包问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class thing {
    thing(int type, int v, int w) {
        this.type = type;
        this.v = v;
        this.w = w;
    }

    int type;
    int v;
    int w;
}

//混合背包问题
public class Solution8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<thing> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int thingv = sc.nextInt();
            int thingw = sc.nextInt();
            int thingt = sc.nextInt();
            if (thingt < 0) {
                thing t = new thing(-1, thingv, thingw);
                list.add(t);
            } else if (thingt == 0) {
                thing t = new thing(thingt, thingv, thingw);
                list.add(t);
            } else {
                for (int j = 1; j <= thingt; j *= 2) {
                    thingt -= j;
                    list.add(new thing(-1, thingv * j, thingw * j));
                }
                if (thingt > 0) {
                    list.add(new thing(-1, thingv * thingt, thingw * thingt));
                }
            }
        }
        int dp[] = new int[m + 1];
        for (thing thing : list) {
            if (thing.type == 0) {
                for (int i = thing.v; i <= m; i++) {
                    dp[i] = Math.max(dp[i], dp[i - thing.v] + thing.w);
                }
            } else {
                for (int i = m; i >= thing.v; i--) {
                    dp[i] = Math.max(dp[i], dp[i - thing.v] + thing.w);
                }
            }
        }
        System.out.println(dp[m]);
    }
}

