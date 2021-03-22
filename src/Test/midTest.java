package Test;

import java.util.ArrayList;
import java.util.List;

public class midTest {
    private static void addin(List<Integer> list, int num) {
        int left = 0;
        int right = list.size()-1;
        while (left <=right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < num) {
                left = mid+1 ;
            } else {
                right = mid - 1;
            }
        }
        list.add(left, num);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        addin(list,4);
        addin(list,7);
        addin(list,3);
        addin(list,-1);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
