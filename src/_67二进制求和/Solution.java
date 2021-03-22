package _67二进制求和;

/**
 * 67. 二进制求和
 * 难度
 * 简单
 *
 * 506
 *
 *
 *
 *
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//效率低
class Solution {
    static int indexa;
    static int indexb;
    static StringBuffer sb;
    public static String addBinary(String a, String b) {
        sb = new StringBuffer();
        sb.append(0);
        indexa = a.length()-1;
        indexb = b.length()-1;
        while (indexa>=0&&indexb>=0)
        {
            fun(a,b);
        }
        if(indexa==-1&&indexb==-1) {
            if(sb.charAt(0)=='0')
            {
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }
        if(indexa==-1)
        {
            while (indexb>=0)
            {
                fun("",b);
            }
        }
        if(indexb==-1)
        {
            while (indexa>=0)
            {
               fun(a,"");
            }
        }
        if(sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void fun(String a,String b){
        char c = sb.charAt(0);
        int ch = c-'0';
        int num=ch;
        if(a.length()!=0)
        {
            int ach = a.charAt(indexa)-'0';
            num+=ach;
        }
        if(b.length()!=0)
        {
            int bch = b.charAt(indexb)-'0';
            num+=bch;
        }
        if(num==3)
        {
            sb.insert(0,1);
        }
        else if(num==2)
        {
            sb.deleteCharAt(0);
            sb.insert(0,0);
            sb.insert(0,1);
        }
        else if(num==1)
        {
            sb.deleteCharAt(0);
            sb.insert(0,1);
            sb.insert(0,0);
        }
        else
        {
            sb.insert(0,0);
        }
        if(a.length()!=0)
        indexa--;
        if(b.length()!=0)
        indexb--;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("0","0"));
    }
}