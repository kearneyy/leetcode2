package Test;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        set1.add('a');
        set1.add('b');
        set1.add('c');
        set2.add('c');
        set2.add('b');
        set2.add('a');
        System.out.println(set1.equals(set2));
    }

}
