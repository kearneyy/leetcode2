package _120三角形最小路径和;

import java.util.LinkedList;
import java.util.List;
//尝试用滚动数组优化
//横着遍历 每次用最左边和头顶（滚动数组中即是自己，最小的那个数来加）
//其实可以再原list上改数字

/**
 * * [
 * *      [2],
 * *     [3,4],
 * *    [6,5,7],
 * *   [4,1,8,3]
 * * ]
 * <p>
 * * 2 3 6 4   2 5 11 15
 * * 4 5 1
 * * 7 8
 * * 3
 */

//滚动数组，压缩成了一维数组
class Solution2 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        if(length==1)
            return triangle.get(0).get(0);
        int[] num = new int[length];//建立一维数组
        num[0]=triangle.get(0).get(0);
        int min = (int)Double.POSITIVE_INFINITY;
        for (int j = 0; j < length; j++) {//从上往下遍历竖着
            for (int i = j; i < length; i++) {
                if(j==0)//第一次先将数组赋值
                {
                    if(i!=0)
                    num[i]=num[i-1]+triangle.get(i).get(j);
                }
                else{
                    if (i == j) {
                        num[i-j]+=triangle.get(i).get(j);
                    }
                    else
                    {
                        num[i-j]=Math.min(num[i-j],num[i-j-1])+triangle.get(i).get(j);
                    }
                }//判断最后一个
                if(i-j==length-1-j)
                {
                    if(num[i-j]<min)
                    {
                        min=num[i-j];
                    }
                }
            }
        }
        return min;
    }


    /**
     * 2	5	11	15
     * 6	10	11
     * 13	18
     * 16
     * 填数字顺序
     * 最后的一维数组 16 18 11 15找出最小值即可
     */

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(-1);

        List<Integer> list2 = new LinkedList<>();
        list2.add(-2);
        list2.add(-3);
//
//        List<Integer> list3 = new LinkedList<>();
//        list3.add(6);
//        list3.add(5);
//        list3.add(7);
//
//        List<Integer> list4 = new LinkedList<>();
//        list4.add(4);
//        list4.add(1);
//        list4.add(8);
//        list4.add(3);

        List<List<Integer>> lists = new LinkedList<>();
        lists.add(list1);
        lists.add(list2);
//        lists.add(list3);
//        lists.add(list4);
        int min = minimumTotal(lists);
        System.out.println(min);
    }

}
