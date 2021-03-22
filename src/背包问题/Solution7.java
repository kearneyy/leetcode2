package 背包问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//多重背包问题,可以把n份拿来拆开，但是一个一个拆复杂度相同，而是用2进制的思想
//比如7可以拆成1 2 4  2的0次 2的1次 2的2次 1-7的每个数都可以用拆出来的东西得到
//10拆成 1 2 4  10-1-2-7  3   不能用1 2 4 8 否则加出来的大于10，这样就可以转化为01背包问题，可以拆成logs份

class good{
    good(int v,int w)
    {
        this.v=v;
        this.w=w;
    }
    int v;
    int w;
}


public class Solution7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        List<good> lists = new ArrayList<>();
        //分片
        for (int i = 0; i < n; i++) {
            int totalv=s.nextInt();
            int totalw=s.nextInt();
            int num = s.nextInt();
            for (int j = 1; j <= num; j*=2) {
                good g= new good(j*totalv,j*totalw);
                num-=j;
                lists.add(g);
            }
            if(num>0)
            {
                lists.add(new good(num*totalv,num*totalw));
            }
        }
        int dp[] = new int[m+1];
        for (int i =0; i < lists.size(); i++) {
            for (int j = m; j >=lists.get(i).v ; j--) {
                dp[j]=Math.max(dp[j],dp[j-lists.get(i).v]+lists.get(i).w);
            }
        }
        System.out.println(dp[m]);
    }
}