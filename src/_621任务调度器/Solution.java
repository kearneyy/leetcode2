package _621任务调度器;

import java.util.*;

/**
 * 621. 任务调度器
 * 难度
 * 中等
 * 反馈
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 * 示例 1：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 * 示例 2：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 0
 * 输出：6
 * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * 诸如此类
 * 示例 3：
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 */

//超时
class Solution {
    public static int leastInterval(char[] tasks, int n) {
        int nums[] = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            nums[tasks[i] - 'A']++;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]});
            }
        }
        Comparator<int[]> com = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        };
        Collections.sort(list, com);
        int daimin = 26;
        int count = 0;
        Deque<Integer> deque = new ArrayDeque<>(n + 1);
        while (count < tasks.length) {
            if (deque.size() == n + 1) {
                deque.removeFirst();
            }
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                int[] temp = list.get(i);
                if (!deque.contains(temp[0])) {
                    deque.addLast(temp[0]);
                    count++;
                    int numfirst=temp[0];
                    temp[1]--;
                    int numsecond=temp[1];
                    list.remove(i);

                    if(numsecond!=0)
                    {
                        int index = -1;
                        for (int j = list.size() - 1; j >= 0; j--) {
                            if (list.get(j)[1] >= temp[1]) {
                                index = j;
                                break;
                            }
                        }
                        list.add(index+1,new int[]{numfirst,numsecond});
                    }
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                deque.add(daimin++);
            }
        }

        return tasks.length + daimin - 26;
    }


    public static void main(String[] args) {
        char[] task = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
//        char[] task = new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'};
//        char[] task = new char[]{'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};
        int i = leastInterval(task, 2);
        System.out.println(i);
    }
}