package _43字符串相乘;

//自己改版本
public class Solution4 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0")||num2.equals("0"))
            return "0";
        int[] num = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0 ; i--) {
            int s1 = num1.charAt(i)-'0';
            for (int j = num2.length()-1; j >=0; j--) {
                int s2 = num2.charAt(j)-'0';
                int total = s1*s2;
                int ge = total%10;
                int shi = total/10;
                num[i+j]+=shi;
                num[i+j+1]+=ge;

                for (int k = i+j+1; k >=0&&k>=i+j-2; k--) {
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

        System.out.println(multiply("96","313"));
    }
}
