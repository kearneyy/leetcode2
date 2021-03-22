package _43字符串相乘;

/**
 * 43. 字符串相乘
 * 难度
 * 中等
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class Solution2 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0"))
            return "0";
        int[] num = new int[num1.length()+num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int s1 = num1.charAt(i)-'0';
                int s2 = num2.charAt(j)-'0';
                int total = s1*s2;
                int ge = total%10;
                int shi = total/10;
                num[i+j]+=shi;
                num[i+j+1]+=ge;

                for (int k = i+j+1; k >=0; k--) {
                    if(num[k]>9)
                    {
                        num[k]-=10;
                        num[k-1]+=1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(num[0]!=0)
            sb.append(num[0]);
        for (int i = 1; i < num.length; i++) {
            sb.append(num[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(multiply("999","999"));
    }
}
