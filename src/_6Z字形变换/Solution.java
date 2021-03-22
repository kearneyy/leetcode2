package _6Z字形变换;

/**
 * 6. Z 字形变换
 * 难度
 * 中等
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */


//构造numRows个Stringbuffer 然后0 1 2 3 2 1 0 1 2 ...找这个和i的规律
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }
        int turn = 1;//turn为1为正 -1为负 //turn是找规律 用官方题解会更好，定义一个boolean变量 每到一定位置就变成他的相反
        int index=0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(i%(2*(numRows-1))==0)
            {
                turn =1;
            }
            if((i-(numRows-1))%(2*(numRows-1))==0)
            {
                turn =-1;
            }
            list.get(index).append(c[i]);
            if(turn==1)
            {
                index++;
            }if(turn==-1)
            {
                index--;
            }
        }
        for (int i = 1; i < numRows; i++) {
            list.get(0).append(list.get(i));
        }
        return list.get(0).toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("A",1));
    }
}
//

//0 1 2 1 0 1 2 1 0 1 2  1  0
//0 1 2 3 4 5 6 7 8 9 10 11 12 13  14 15 16 17  18