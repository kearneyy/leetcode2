package _767重构字符串;

/**
 * 难度
 * 中等
 *
 * 207
 *
 * 收藏
 *
 * 分享
 *
 * 切换为英文
 *
 * 接收动态
 *
 * 反馈
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 */
class Solution {
    public static String reorganizeString(String S) {
        int nums[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
            nums[S.charAt(i)-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        int min=Integer.MAX_VALUE;
        int lastIndex= 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]<=min)
            {
                lastIndex=i;
                min=nums[i];
            }
        }
        while (sb.length()!=S.length())
        {
            lastIndex = findMaxIndex(nums,lastIndex);
            if(lastIndex!=-1)
            {
                sb.append( (char)('a'+lastIndex));
                nums[lastIndex]--;
            }
            else
            {
                return "";
            }
        }
        for (int i = 0; i < sb.length()-1; i++) {
            if(sb.charAt(i)==sb.charAt(i+1))
            {
                return "";
            }
        }
        return sb.toString();
    }

    public static int findMaxIndex(int nums[],int lastIndex)
    {
        int maxindex=-1;
        int maxNum=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        if(i==lastIndex)
        {
            continue;
        }
        if(nums[i]>maxNum)
        {
            maxNum=nums[i];
            maxindex=i;
        }
    }
        if(maxNum==0&&nums[lastIndex]!=0)
            return -1;
        return maxindex;
}

    public static void main(String[] args) {
        String s = "aaba";
        String s1 = reorganizeString(s);
        System.out.println(s1);
    }
}