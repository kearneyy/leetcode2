package _1232缀点成线;

/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//构造一次函数
class Solution {
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2)
            return true;
        boolean flag = false;
        if ((coordinates[1][0] - coordinates[0][0]) == 0)
            flag = true;
        float k = 0;
        float b = 0;
        if(!flag)
        {
             k = ((float)(coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]));
             b = coordinates[0][1]-k*coordinates[0][0];
        }
        for (int i = 1; i < coordinates.length; i++) {
            int fz =  (coordinates[i][0] - coordinates[i-1][0]);
            if(flag)
            {
                if(fz!=0)
                {
                    return false;
                }
            }
            else
            {
                if(fz==0)
                    return false;
                if(k*coordinates[i][0]+b!=coordinates[i][1])
                {
                    return false;
                }
            }

        }
        return true;
}




public static void main(String[]args){
//        int[][]a=new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        int[][]a=new int[][]{{2,1},{4,2},{6,3}};
        boolean b=checkStraightLine(a);
        System.out.println(b);
        }
}