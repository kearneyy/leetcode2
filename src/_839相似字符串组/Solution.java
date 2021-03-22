package _839相似字符串组;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

/**
 * 839. 相似字符串组
 * 难度
 * 困难
 *
 * 89
 *
 *
 *
 *
 *
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 *
 * 示例 1：
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * 示例 2：
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 */

//str转成char[]太耗时了！
class unionfind{
    int count;
    int[] parent;
    int[] size;

    public unionfind(int n){
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] =1;
        }
    }

    public int find(int x){
        while (x!=parent[x])
        {
            parent[x] =  parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY)
            return false;
        if(size[rootX]>size[rootY])
        {
            parent[rootY] = rootX;
            size[rootX]+=size[rootY];
        }
        else
        {
            parent[rootX] = rootY;
            size[rootY] += size[rootY];
        }
        count--;
        return true;
    }

    public boolean isconnected(int x,int y){
        return find(x)==find(y);
    }
}


class Solution {
    public static int numSimilarGroups(String[] strs) {
        Map<String,Integer> map =new HashMap<>();
        unionfind uf = new unionfind(strs.length);
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if(!map.containsKey(str))
            {
                map.put(str,i);
            }
            else
            {
                Integer integer = map.get(str);
                uf.union(i,integer);
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            String key = stringIntegerEntry.getKey();
            for (Map.Entry<String, Integer> integerEntry : map.entrySet()) {
                String key2 = integerEntry.getKey();
                int value = integerEntry.getValue();
                int value2 = stringIntegerEntry.getValue();
                if(key.equals(key2))
                    continue;
                if(uf.isconnected(value,value2))
                {
                    continue;
                }
                if(isSimilar(key,key2))
                {
                    uf.union(value,value2);
                }
            }
        }
        return uf.count;
    }


    public static boolean isSimilar(String str1,String str2)
    {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            if(chars1[i]!=chars2[i])
            {
                count++;
            }
        }
        return count==2;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"tars","rats","arts","star"};
        int i = numSimilarGroups(strs);
        System.out.println(i);
    }
}
