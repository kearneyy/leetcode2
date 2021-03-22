package _118杨辉三角;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 难度
 * 简单
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

//简单题
class Solution {
    public  List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        if(numRows==0)
            return lists;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> templist = new ArrayList<>();
            templist.add(1);
            templist.add(1);
            lists.add(templist);
        }

        for (int i = 2; i < numRows; i++) {
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
        return lists;
    }
}