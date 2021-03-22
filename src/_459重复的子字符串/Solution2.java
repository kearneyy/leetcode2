package _459重复的子字符串;

/**
 * 官方
 */

//abcabcabc
class Solution2 {//思路差不多 但是改成一个一个字符循环判断，就会快很多
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}

//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
