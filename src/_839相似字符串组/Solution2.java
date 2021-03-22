package _839相似字符串组;

import java.util.HashMap;
import java.util.Map;


//不用hash存
class Solution2 {
    public static int numSimilarGroups(String[] strs) {
        unionfind uf = new unionfind(strs.length);
        for (int i = 0; i < strs.length-1; i++) {
            for (int j = i; j <strs.length ; j++) {
                if(isSimilar(strs[i],strs[j]))
                {
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }


    public static boolean isSimilar(String str1,String str2)
    {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if(str2.charAt(i)!=str1.charAt(i))
            {
                count++;
            }
            if(count>2)
                return false;
        }
        return count==2||count==0;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"tars","rats","arts","star"};
        int i = numSimilarGroups(strs);
        System.out.println(i);
    }
}
