package _424替换后的最长重复字符;

import java.util.HashMap;
import java.util.Map;

//自己写的 参考了一下思路 但是没看全 效率很低
public class Solution2 {
    public static int characterReplacement(String s, int k) {
        if(s.length()+1<k)
            return s.length();
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        for (; right <s.length() ; right++) {
            int count =k;
            int key = s.charAt(right) - 'A';
            int num = map.getOrDefault(key,0);
            num++;
            map.put(key,num);
            int sum = 0;
            int maxvalue = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                Integer tempvalue = integerIntegerEntry.getValue();
                if(tempvalue>maxvalue)
                {
                    maxvalue = tempvalue;
                }
                sum+=tempvalue;
            }
            sum-=maxvalue;
            if(count-sum<0)
            {
                Integer integer = map.get(s.charAt(left)-'A');
                integer--;
                if(integer==0)
                {
                 map.remove(s.charAt(left)-'A');
                }
                else
                {
                    map.put(s.charAt(left)-'A',integer);
                }
                left++;
            }
        }
        return right==s.length()?right-left:right-left+1;
    }

    public static void main(String[] args) {
        int aaaa = characterReplacement("AAAA", 2);
        System.out.println(aaaa);
    }
}
