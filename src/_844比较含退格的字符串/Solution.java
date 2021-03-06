package _844比较含退格的字符串;

/**
 * 844. 比较含退格的字符串
 * 难度
 * 简单
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 */
class Solution {
    public static boolean backspaceCompare(String S, String T) {
        StringBuffer sb1 = new StringBuffer(S);
        StringBuffer sb2 = new StringBuffer(T);
        int len1 = S.length();
        int len2 = T.length();
        return deleteString(sb1,len1).equals(deleteString(sb2,len2));
    }

    public static String deleteString(StringBuffer S,int size)
    {
        for (int i = 0; i < size; i++) {
            if(S.charAt(i)=='#')
            {
                if(i!=0)
                {
                    S=S.delete(i-1,i+1);
                    i=i-2;
                    size=size-2;
                }
                else
                {
                    S=S.deleteCharAt(i);
                    i--;
                    size=size-1;
                }
            }
        }
        return S.toString();
    }

    public static void main(String[] args) {
        String s ="#";
        String b = "";
        boolean b1 = backspaceCompare(s, b);
        System.out.println(b1);
    }
}