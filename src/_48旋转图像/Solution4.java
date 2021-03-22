package _48旋转图像;

//自己写的
class Solution4 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                change(matrix,i,j,matrix.length-1-i,j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                change(matrix,i,j,j,i);
            }
        }
    }

    public void change(int[][] matrix,int x1,int y1,int x2,int y2)
    {
        int temp=matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]=temp;
    }
}
