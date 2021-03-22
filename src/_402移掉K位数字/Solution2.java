package _402移掉K位数字;

/**
 * 思路，从左到右，找第一个比后面大的字符，删除，清零，k次扫描。
 */
public class Solution2 {
        public static String removeKdigits(String num, int k) {
            if (num.length() == k) return "0";
            StringBuilder s = new StringBuilder(num);
            for (int i = 0; i < k; i++) {
                int idx = 0;
                for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
                s.delete(idx, idx + 1);
                while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);//0直接全清再继续下一次遍历，就不用考虑0的情况
            }
            return s.toString();
        }

    public static void main(String[] args) {
        String s = removeKdigits("10000111", 3);
        System.out.println(s);
    }
}
