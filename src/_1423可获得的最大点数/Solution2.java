package _1423可获得的最大点数;

//滑动窗口，有点复杂，感觉和前缀和差不多
public class Solution2 {
    public static int maxScore(int[] cardPoints, int k) {
        int maxValue = 0, sum = 0;
        int startIndex = 0 - k;
        for (int left = startIndex, right = startIndex; right < k; right++) {
            // right的真实下标为： right >= 0 ? right : right + cardPoints.length
            sum += cardPoints[right >= 0 ? right : right + cardPoints.length];

            // 滑动窗口构建完成，开始比较最大值，并且删除已不在滑动窗口的值
            if (right - left >= k - 1) {
                // 若左指针已经离开起始位置, 需要减去已不在滑动窗口的值
                if (left > startIndex) {
                    sum -= cardPoints[left - 1 >= 0 ? left - 1 : left - 1 + cardPoints.length];
                }
                maxValue = maxValue < sum ? sum : maxValue;
                left++;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,4,5,6,1};
        int score = maxScore(nums, 3);
        System.out.println(score);
    }
}
