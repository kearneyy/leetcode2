package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class yz2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String[] strs = s1.split(" ");
        int len = strs.length;
        int[][] num = new int[len][2];
        int index=0;
        for (String str : strs) {
            StringBuilder sb1 = new StringBuilder();
            for (int i = 5; i <str.length() ; i++) {
                if(str.charAt(i)>='0'&&str.charAt(i)<='9')
                {
                    sb1.append(str.charAt(i));
                }
                else
                {
                    break;
                }
            }

            num[index][0]=Integer.parseInt(sb1.toString());
            StringBuilder sb2 = new StringBuilder();
            for (int i = str.length()-2; i >=0 ; i--) {
                if(str.charAt(i)>='0'&&str.charAt(i)<='9')
                {
                    sb2.insert(0,str.charAt(i));
                }
                else
                {
                    break;
                }
            }
            num[index][1]=Integer.parseInt(sb2.toString());
            index++;
        }
        int in[] = new int[len+2];
        int out[] = new int[len+2];
        for (int i = 0; i < num.length; i++) {
            in[num[i][0]]++;
            out[num[i][1]]++;
        }
        int first = 0;
        int last = 0;
        for (int i = 1; i < len+2; i++) {
            if(in[i]==0)
            {
                last=in[i];
            }
        }

        for (int i = 1; i < len+2 ; i++) {
            if(out[i]==0)
            {
                first=in[i];
            }
        }
        int changdu = 0;

        String getnode = s.nextLine();
        StringBuilder sb3 = new StringBuilder();
        for (int i = getnode.length()-1; i >=0 ; i--) {
            if(getnode.charAt(i)>='0'&&getnode.charAt(i)<='9')
            {
                sb3.insert(0,getnode.charAt(i));
            }
            else
            {
                break;
            }
        }
        int get=Integer.parseInt(sb3.toString());

        List<Integer> list = new ArrayList<>();
        while (list.size()<=len)
        {
            list.add(first);
            for (int i = 0; i < num.length; i++) {
                if(num[i][0]==first)
                {
                    first=num[i][1];
                    break;
                }
            }
        }
        int getindex=0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)-get==0)
            {
                getindex=i;
                break;
            }
        }
        System.out.println(getindex+" "+(list.size()-getindex-1));
    }
}
