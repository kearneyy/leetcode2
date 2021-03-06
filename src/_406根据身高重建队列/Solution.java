package _406根据身高重建队列;

import java.util.*;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }

        /*
            按照 如下规则，给数组排序：
                若两人身高相等，将 p[1]小的 排在前面(这样才能保证 后面的p[1]条件满足)
                若两人身高不等，将 身高高的 排在前面
         */

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };
        Arrays.sort(people,comparator);

        /*
            根据 排在当前人前面的、比当前人高的 人数，将 所有人放入list中
            由于上面的排序，导致 我们放置后的list中：k值大的排在k值小的后面，k值相同的：身高高的排在身高低的后面
            高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
         */
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(people);
    }


    public static void main(String[] args) {
        int num[][] = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = reconstructQueue(num);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }
    }
}