package _207课程表;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 **/


import java.util.*;

/**
 * 用队列+拓扑排序，广度优先
 * prerequisites是一个二维矩阵，多行两列，第一列是是要完成的课程，第二列是先修课程
 * 创造一个入度表，当入度为0了就把那个加入队列
 * 之后从队列中取出元素后修改入度表，将先修课是队列该元素的要完成课程入度-1
 * 如果所有学完返回true否则返回false
 */
class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;
        if(prerequisites.length==1)
            return true;
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            count++;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == cur) {
                    indegree[prerequisite[0]]--;
                    if (indegree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] pre = {{0,1},{0,2},{1,2}};
        boolean b = canFinish(3, pre);
        System.out.println(b);
    }
}