package _381O1时间插入删除和获取随机元素允许重复;

import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 *
 * 	insert(val)：向集合中插入元素 val。
 * 	remove(val)：当 val 存在时，从集合中移除一个 val。
 * 	getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 *
 *
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class RandomizedCollection {

    Map<Integer, Set<Integer>> map; //set存出现的索引方便删除
    List<Integer> list; //list用于getRandom
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int size = list.size();
        list.add(val);
        if(map.containsKey(val))
        {
            Set<Integer> set = map.get(val);
            set.add(size);
            map.put(val,set);
            return false;
        }
        else
        {
            Set<Integer> set = new HashSet<>();
            set.add(size);
            map.put(val,set);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    /**
     * 要删除一个数
     * 从map中找这个数 如果存在，找他的set
     * 取出其中一个下标记作next
     * 找到list最后一个 下标记作lastnum
     * list的下标为next的替换成lastnum
     * set把next移除
     * 找到lastnum在的set，然后把该set中该下标移除加入下标next
     * 把list最后一个移除
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
        }
        else
        {
            Set<Integer> set = map.get(val);
            Iterator<Integer> iterator = set.iterator();
            Integer next = iterator.next();//要删除数字的其中一个下标
            Integer lastNum = list.get(list.size() - 1);
            list.set(next,lastNum);
            set.remove(next);
            Set<Integer> set2 = map.get(lastNum);
            set2.remove(list.size()-1);
            if(next<list.size()-1)
            {
                map.get(lastNum).add(next);
            }
            if(set.size()==0)
            {
                //如果删除后这个数都被删完了,这个顺序不能调换
                map.remove(val);
            }
            set2.add(next);
            list.remove(list.size()-1);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random()*list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
