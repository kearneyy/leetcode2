package _733图像渲染;

/**
 * 733. 图像渲染
 * 难度
 * 简单
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 * 示例 1:
 * 输入:
 * image = [[1,1,1]
 *         [1,1,0]
 *         [1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [ [2,2,2]
 *        [2,2,0]
 *        [2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 *
 * [0,0,0]
 * [0,1,1]
 *
 * 1,1,1
 */

//深度优先遍历
class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image.length==0)
            return image;
        if(image[0].length==0)
            return image;
        int oldColor = image[sr][sc];
        if(oldColor==newColor)
            return image;
       dfs(image,sr,sc,oldColor,newColor);
       return image;
    }

    private static void dfs(int[][] image,int sr,int sc,int oldColor,int newColor){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=oldColor)
            return;
        image[sr][sc]=newColor;
        dfs(image,sr-1,sc,oldColor,newColor);
        dfs(image,sr,sc-1,oldColor,newColor);
        dfs(image,sr,sc+1,oldColor,newColor);
        dfs(image,sr+1,sc,oldColor,newColor);
    }

    public static void main(String[] args) {
//        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int[][] image = new int[][]{{0,0,0},{0,1,1}};
        int[][] newimage = floodFill(image,1,1,1);
        for (int i = 0; i < newimage.length; i++) {
            for (int j = 0; j < newimage[0].length; j++) {
                System.out.print(newimage[i][j]);
            }
            System.out.println();
        }
    }
}