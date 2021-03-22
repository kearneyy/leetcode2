package _210课程表II;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 难度
 * 中等
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * BFS
 * BFS 的总体思路：
 * <p>
 * 建立入度表，入度为 0 的节点先入队
 * 当队列不为空，节点出队，标记学完课程数量的变量加 1，并记录该课程
 * 将课程的邻居入度减 1
 * 若邻居课程入度为 0，加入队列
 * 用一个变量记录学完的课程数量，一个数组记录最终结果，简洁好理解。
 * <p>
 * 作者：kelly2018
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/java-jian-dan-hao-li-jie-de-tuo-bu-pai-xu-by-kelly/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return new int[0];
        int count = 0;
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            res[count++] = poll;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == poll) {
                    inDegrees[prerequisites[i][0]]--;
                    if (inDegrees[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                    }
                }

            }
        }
        if (count == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        int[] a= findOrder(4,pre);
        for (int s : a) {
            System.out.println(s);
        }
    }
}