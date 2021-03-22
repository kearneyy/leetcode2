package Test;

import java.util.ArrayList;
import java.util.List;

public class add {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        add(list,1);
        add(list,5);
        add(list,3);
        add(list,3);
        add(list,8);
        add(list,6);
        add(list,1);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void add(List<Integer> list, int num)
    {
        if(list.size()==0)
        {
            list.add(num);
            return;
        }
        int i = 0;
        int len = list.size();
        for(;i<len;i++)
        {
            if(num<list.get(i))
            {
                break;
            }
        }
        list.add(i,num);
    }
}
