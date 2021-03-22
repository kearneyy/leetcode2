package _224基本计算器;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    //自己的错误写法
    public static int calculate(String s) {
        String replaces = s.replace(" ", "");
        Deque<Character> chardeque = new ArrayDeque<>();
        Deque<Integer> numdeque = new ArrayDeque<>();
        int index = 0;
        while (index < replaces.length()) {
            while (index < replaces.length() && replaces.charAt(index) != ')') {
                if (replaces.charAt(index) == '+' || replaces.charAt(index) == '-' || replaces.charAt(index) == '(') {
                    chardeque.addLast(replaces.charAt(index));
                } else {
                    if(!numdeque.isEmpty()&&(replaces.charAt(index-1)-'0'>=0&&replaces.charAt(index-1)-'0'<=9))
                    {
                        int beforenum = numdeque.pollLast();
                        numdeque.addLast(beforenum*10+replaces.charAt(index) - '0');
                    }
                    else
                    {
                        numdeque.addLast(replaces.charAt(index) - '0');
                    }
                }
                index++;
            }
            if (index < replaces.length()) {
                while (chardeque.peekLast() != '(') {
                    char flag = chardeque.pollLast();
                    if (flag == '+') {


                        int num1 = numdeque.pollLast();
                        int num2 = numdeque.pollLast();
                        if (!chardeque.isEmpty()) {
                            char flag2 = chardeque.peekLast();
                            if (flag2 == '-') {
                                numdeque.addLast(num1 + num2);
                                numdeque.pollLast();
                            } else {
                                numdeque.addLast(num1 + num2);
                            }
                        } else {
                            numdeque.addLast(num1 + num2);
                        }
                    } else if (flag == '-') {
                        int num1 = numdeque.pollLast();
                        int num2 = numdeque.pollLast();
                        if (!chardeque.isEmpty()) {
                            char flag2 = chardeque.peekLast();
                            if (flag2 == '-') {
                                numdeque.addLast(-num1 - num2);
                                numdeque.pollLast();
                            } else {
                                numdeque.addLast(num2 - num1);
                            }
                        } else {
                            numdeque.addLast(num2 - num1);
                        }

                    }
                }
                chardeque.pollLast();
                index++;
            } else {
                if(chardeque.isEmpty())
                {
                    return Integer.valueOf(replaces);
                }
                while (!chardeque.isEmpty()) {
                    char flag = chardeque.pollLast();
                    if (flag == '+') {
                        int num1 = numdeque.pollLast();
                        int num2 = numdeque.pollLast();
                        if (!chardeque.isEmpty()) {
                            char flag2 = chardeque.peekLast();
                            if (!chardeque.isEmpty()) {
                                if (flag2 == '-') {
                                    numdeque.addLast(-num2 + num1);
                                    chardeque.pollLast();
                                } else {
                                    numdeque.addLast(num1 + num2);
                                }
                            } else {
                                numdeque.addLast(num1 + num2);
                            }
                        } else {
                            numdeque.addLast(num1 + num2);
                        }

                    } else if (flag == '-') {
                        int num1 = numdeque.pollLast();
                        int num2 = numdeque.pollLast();
                        if (!chardeque.isEmpty()) {
                            char flag2 = chardeque.peekLast();
                            if (flag2 == '-') {
                                numdeque.addLast(-num1 - num2);
                                chardeque.pollLast();
                            } else {
                                numdeque.addLast(num2 - num1);
                            }
                        } else {
                            numdeque.addLast(num2 - num1);
                        }
                    }
                }
            }
        }
        int total = 0;
        while (!numdeque.isEmpty()) {
            total += numdeque.pollLast();
        }
        if(!chardeque.isEmpty()&&chardeque.peekLast().toString().equals("-"))
            return -total;
        return total;
    }

    public static void main(String[] args) {
        int calculate = calculate(" 2-1 + 2 ");
        System.out.println(calculate);
    }
}
