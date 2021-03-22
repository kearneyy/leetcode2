package _119杨辉三角II;

import java.util.ArrayList;
import java.util.List;

/**
 119. 杨辉三角 II
 难度
 简单
 186
 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

 在杨辉三角中，每个数是它左上方和右上方的数的和。
 示例:
 输入: 3
 输出: [1,3,3,1]
 * ]
 */

//简单题,跟上一题一样
class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if(rowIndex+1==0)
            return list;
        list.add(1);
        lists.add(list);
        for (int i = 1; i <rowIndex+1; i++) {
            List<Integer> templist = new ArrayList<>();
            templist.add(1);
            templist.add(1);
            lists.add(templist);
        }

        for (int i = 2; i < rowIndex+1; i++) {
            int left=0;
            int right=1;
            int index=1;
            List<Integer> beforelist = lists.get(i - 1);
            List<Integer> nowlist = lists.get(i);
            for (int j = 1; j<i; j++) {
                Integer leftnum = beforelist.get(left);
                Integer rightnum = beforelist.get(right);
                left++;
                right++;
                nowlist.add(index,leftnum+rightnum);
                index++;
            }
        }
        return lists.get(lists.size()-1);
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(1);
        System.out.println(row);
    }
}