package _316去除重复字母;

import java.util.*;

/**
 *
 *
 */

//自己写的 有点乱
class Solution2 {
    public static String removeDuplicateLetters(String s) {
        int[] num = new int[s.length()];
        int[] last = new int[26];
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                count++;
                num[i] = count;

            } else {
                num[i] = count;
            }
        }
        Arrays.fill(last,-1);
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)-'a']=i;
        }
        int total = set.size();
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = set.iterator();
        long sum=1;
        boolean find[] = new boolean[26];//有出现过的都设为true，其他设为false
        while (iterator.hasNext()) {
            Character next = iterator.next();
            find[next - 'a'] = true;
        }
        int index=0;
        while (sb.length() != total) {
            for (int i = 0; i < 26; i++) {
                if (find[i]) {//找到要加入的字母
                    char word = (char) ('a' + i);//找下面有没有这个字母
                    boolean flag=false;

                    for (int j = index; j < s.length() ; j++) {
                        if(num[j]<count)
                        {
                            break;
                        }
                        if (s.charAt(j) == word) {
                            boolean unuse = false;
                            for (int k = 0; k <26; k++) {
                                if(find[k])
                                {
                                    if(last[k]<j)
                                    {
                                        unuse=true;
                                        break;
                                    }
                                }
                            }
                            if (unuse)
                            {
                                break;
                            }
                            sb.append(word);
                            find[word - 'a'] = false;
                            index = j+1;
                            count--;
                            flag=true;
                            break;
                        }
                    }
                    if(flag)
                    {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String bcbcaddabc = removeDuplicateLetters("ecbacba");
        System.out.println(bcbcaddabc);
    }
}