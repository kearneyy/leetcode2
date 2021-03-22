package Test;

import java.util.Scanner;

public class yz {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        float total=0;
        int zs=200;
        for (int i = 0; i < n; i++) {
            String next = s.next();
            char type = next.charAt(0);
            int weigh = s.nextInt();
            float money = s.nextFloat();
            if(type=='R')
            {
                if(weigh>=zs)
                {
                    weigh-=zs;
                    zs=0;
                    total+=weigh*money/100;
                }
                else
                {
                    zs-=weigh;
                }
            }
            else
            {
                total+=weigh*money/100;
            }
        }
        int go = s.nextInt();
        if(go<6000)
        {
            System.out.println(String.format("%.2f",total));
        }
        else if(go<10000)
        {
            System.out.println(String.format("%.2f", total*0.9));
        }
        else
        {
            System.out.println(String.format("%.2f", total*0.8));
        }
    }
}
