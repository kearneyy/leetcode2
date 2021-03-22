package LCP19秋叶收藏集;

class Solution2 {
    public static int minimumOperations(String leaves) {
        int length = leaves.length();
        int[][] f = new int[length][3];
        f[0][0]=leaves.charAt(0)=='r'?0:1;
        f[0][1]=f[0][2]=f[1][2]=Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            int isYellow = leaves.charAt(i)=='y'?1:0;
            int isRed = leaves.charAt(i)=='r'?1:0;
            f[i][0]=f[i-1][0]+isYellow;
            f[i][1]=Math.min(f[i-1][0],f[i-1][1])+isRed;
            if(i>=2)
                f[i][2]=Math.min(f[i-1][1],f[i-1][2])+isYellow;
        }
        return f[length-1][2];
    }

    public static void main(String[] args) {
        int rrryyyrryyyrr = minimumOperations("rrryyyrryyyrr");
        System.out.println(rrryyyrryyyrr);
    }
}