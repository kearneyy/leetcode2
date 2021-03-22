package _119杨辉三角II;

import java.util.ArrayList;
import java.util.List;

/**
 *简单动态规划
 */
class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        int[][] num = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i < rowIndex+1; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i)
                {
                    num[i][j]=1;
                }
                else
                {
                    num[i][j]=num[i-1][j-1]+num[i-1][j];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <rowIndex+1 ; i++) {
            list.add(num[rowIndex][i]);
        }
        return list;
    }
}