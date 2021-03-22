package CCF小明放学;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long[] light = new long[3];
        light[0] = s.nextLong();// 红
        light[2] = s.nextLong();// 黄
        light[1] = s.nextLong();// 绿灯
        int n = s.nextInt();
        int[] type = new int[n];
        long[] second = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            int input = s.nextInt();
            if (input == 2) {
                type[i] = 3;
            } else if (input == 3) {
                type[i] = 2;
            } else
                type[i] = input;
            second[i] = s.nextLong();
        }
        for (int i = 0; i < n; i++) {

                if(type[i]!=0)
                {
                    if (second[i] > total) {
                        second[i] -= total;
                    } else {
                        int color = type[i];
                        do {
                            color++;
                            if (color == 4)
                                color = 1;
                            second[i] = second[i] - total + light[color - 1];
                        } while (second[i] < 0);
                    }
                }
                if(type[i]!=2)
                total+=second[i];
        }
        System.out.println(total);
    }
}
