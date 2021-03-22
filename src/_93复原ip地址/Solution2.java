package _93复原ip地址;

import java.util.*;

//暴力解法
class Solution2 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> r = new ArrayList<>();
        if(s.length() > 12) return r;
        for(int i = 1; i < s.length() && i <= 3; ++i){
            for(int j = i+1; j < s.length() && j <= i + 3; ++j){
                for(int k = j+1; k < s.length() && k <= j + 3; ++k){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if(f(s1)&&f(s2)&&f(s3)&&f(s4)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(s1); sb.append(".");
                        sb.append(s2); sb.append(".");
                        sb.append(s3); sb.append(".");
                        sb.append(s4);
                        r.add(sb.toString());
                    }
                }
            }
        }
        return r;
    }
    static boolean f(String s){
        if(s.length() == 0) return false;
        if(s.length() == 1) return true;
        if(s.length() > 3) return false;
        if(s.charAt(0) == '0') return false;
        if(Integer.parseInt(s) <= 255) return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("25525511135");
        for (String s : list) {
            System.out.println(s);
        }
    }
}