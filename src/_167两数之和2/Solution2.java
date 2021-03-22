package _167两数之和2;
//解法二，二分查找
class Solution2 {
    public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int num = target-numbers[i];
            int left = i+1;
            int right = len-1;
            while(left<=right)//这里不能写小于，二分查找一定是left小于等于right为边界
            {
                int mid = (left+right)/2;
                if(num<numbers[mid])
                {
                    right=mid-1;
                }
                else if(num>numbers[mid])
                {
                    left=mid+1;
                }
                else
                {
                    return new int[]{i+1,mid+1};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int[] index = twoSum(num,22);
        for (int i : index) {
            System.out.println(i);
        }
    }
}