package _49字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//很妙的解法，用26字母对应26个质数
class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] weight = new int[26];
        int w = 2;
        for (int i = 0; i < 26; i++) {
            while (!isPrime(w)) w++;
            weight[i] = w++;
        }
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long key = getKey(str, weight);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private long getKey(String str, int[] weight) {
        long key = 1;
        for (char ch : str.toCharArray()) {
            key *= weight[ch - 'a'];
        }
        return key;
    }
}
