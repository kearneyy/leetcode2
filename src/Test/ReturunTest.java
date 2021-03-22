package Test;

public class ReturunTest {
    public static void main(String[] args) {
       int[] a = xixi(1,2);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] xixi(int a,int b){
        int[] num = new int[2];
        num[0]=a;
        num[1]=b;
        return num;
    }
}
