package _703数据流中的第K大元素;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 *
 * 	KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * 	int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//优先队列  由于只要第k大 存储k个就够
class KthLargest2 {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++)
        {
            queue.add(nums[i]);
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size()>k)
        {
            queue.poll();
        }
        return queue.peek();
    }
}