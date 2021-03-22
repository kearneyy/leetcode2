package _721账户合并;

import java.util.*;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class Solution {
    class unionfind {
        private int[] parent;
        private int[] size;
        private  int count;

        public unionfind(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;
            if (size[x] > size[y]) {
                parent[rootY] = rootX;
                size[rootX] += rootY;
            } else {
                parent[rootX] = rootY;
                size[rootY] += rootX;
            }
            count--;
        }


        public int getSize(int x) {
            int rootX = find(x);
            return size[rootX];
        }

    }


    // 作用：存储每个邮箱属于哪个账户 ，同时 在遍历邮箱时，判断邮箱是否出现过[去重]
    // 格式：<邮箱，账户id>
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> mail = new HashMap<String, Integer>();
        unionfind uf = new unionfind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                if(!mail.containsKey(list.get(j)))
                {
                    mail.put(list.get(j),i);
                }
                else
                {
                    uf.union(i,mail.get(list.get(j)));
                }
            }
        }

        //将Id和邮箱对应
        Map<Integer,List<String>> idtoEmails =new HashMap<Integer, List<String>>();
        for (Map.Entry<String, Integer> stringIntegerEntry : mail.entrySet()) {
            int id =uf.find(stringIntegerEntry.getValue());//找到父亲id 将父亲id加入map，把邮箱当成value
            List<String> list = idtoEmails.getOrDefault(id,new ArrayList<String>());
            list.add(stringIntegerEntry.getKey());
            idtoEmails.put(id,list);
        }

        //将id变成名字并加入邮箱
        List<List<String>> res = new ArrayList<>();
        Set<Map.Entry<Integer, List<String>>> entries = idtoEmails.entrySet();
        for (Map.Entry<Integer, List<String>> entry : entries) {
            List<String> value = entry.getValue();
            Collections.sort(value);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(entry.getKey()).get(0));
            temp.addAll(value);
            res.add(temp);
        }
        return res;
    }
}


