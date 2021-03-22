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

//自己写的 还是错的
class Solution2 {
    public static int[][] reconstructQueue(int[][] people) {
        int num[][] = new int[people.length][2];
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < people.length; i++) {
            if (map.containsKey(people[i][1])) {
                List<Integer> list = map.get(people[i][1]);
                list.add(people[i][0]);
                map.put(people[i][1], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(people[i][0]);
                map.put(people[i][1], list);
            }
        }
        List<int[]> templist = new ArrayList<>();
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            Integer key = entry.getKey();
            List<Integer> list = map.get(key);
            Collections.sort(list);
        }
        while (map.size() != 0) {
            Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, List<Integer>> next = iterator.next();
                Integer key = next.getKey();
                List<Integer> value = next.getValue();
                for (int i = 0; i < value.size(); i++) {
                    if (templist.size() >= key) {
                        templist.add(new int[]{value.get(i), key});
                        value.remove(value.get(i));
                        i--;
                    }
                }
                if(value.size()==0)
                {
                   iterator.remove();
                }
            }
        }
        templist.toArray(num);
        return num;
    }

    public static void main(String[] args) {
        int num[][] = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = reconstructQueue(num);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }
    }
}