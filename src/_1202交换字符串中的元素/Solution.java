package _1202交换字符串中的元素;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 *
 *
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 *
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class unionfind{
    private int n;
    private int[] parent;

    public unionfind(int n){
        this.n = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int[] getParent() {
        return parent;
    }

    public int find(int x){
        if (x!=parent[x])
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x,int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY)
        {
            return;
        }
        parent[rootX] = rootY;
    }
}

class Solution {
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        unionfind uf = new unionfind(s.length());
        for (int i = 0; i < pairs.size(); i++) {
            List<Integer> list = pairs.get(i);
            Integer num1 = list.get(0);
            Integer num2 = list.get(1);
            uf.union(num1,num2);
        }
        int[] parent = uf.getParent();
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int[] charnum;
            int father = uf.find(parent[i]);
            if(!map.containsKey(father))
            {
                 charnum = new int[26];
                charnum[chars[i]-'a']++;

            }
            else
            {
                charnum= map.get(father);
                charnum[chars[i]-'a']++;
            }
            map.put(father,charnum);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int indexofnum = uf.find(parent[i]);
            int[] nums = map.get(indexofnum);
            char first = getfirst(nums);
            sb.append(first);
        }
        return sb.toString();
    }

    public static char getfirst(int[] nums)
    {
        int i = 0;
        for (; i < nums.length; i++) {
            if(nums[i]!=0)
            {
                nums[i]--;
                break;
            }
        }
        return (char)('a'+i);
    }



    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        list2.add(1);
        list2.add(2);
        list3.add(0);
        list3.add(2);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        String dcab = smallestStringWithSwaps("dcab", list);
        System.out.println(dcab);
    }
}
