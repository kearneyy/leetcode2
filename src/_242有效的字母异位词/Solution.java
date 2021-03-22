package _242有效的字母异位词;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int nums1[] = new int[26];
        int nums2[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums1[s.charAt(i)-'a']++;
            nums2[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(nums1[i]!=nums2[i])
                return false;
        }
        return true;
    }
}