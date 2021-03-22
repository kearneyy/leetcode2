package 二分插入;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int len;
    List<Integer> list = new ArrayList<>();
    int k ;

    public  int add(int val) {
        int low=0,high=len-1;
        int middle = 0;
        if(len==0)
            list.add(val);
        while(low <= high)
        {
            middle = (low + high)/2;
            if(list.get(middle) > val)
            {
                //插入位置在data[middle]之前
                high= middle-1;
                if(high < low)
                {
                    list.add(low,val);
                    break;
                }
                else if(list.get(high) <= val)
                {
                    list.add(high+1,val);
                    break;
                }
            }
            else if(list.get(middle)<val)
            {
                //插入位置在data[middle]之后
                low = middle +1;
                if(high<low)
                {
                    list.add(low,val);
                    break;
                }
                else if(list.get(low) >= val)
                {
                    list.add(low,val);
                    break;
                }
            }
            else
            {
                list.add(middle+1,val);
                break;
            }
        }
        len++;
        return list.get(len-k);
    }
}
