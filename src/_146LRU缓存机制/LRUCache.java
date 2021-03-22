package _146LRU缓存机制;

import java.util.*;

/**
 * 146. LRU缓存机制
 * 难度
 * 中等
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
class LRUCache {

    private LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    private int length;
    public LRUCache(int capacity) {
        this.length=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Integer remove = map.remove(key);
            map.put(key,remove);
            return remove;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.size()<length)
        {
            if(map.containsKey(key))
            {
                map.remove(key);
            }
            map.put(key,value);
        }
        else {
            if(!map.containsKey(key))
            {
                Map.Entry<Integer, Integer> head = getHead(map);
                map.remove(head.getKey());
            }
            else
            {
                map.remove(key);
            }
            map.put(key,value);
        }
    }

    public Map.Entry<Integer,Integer> getHead(LinkedHashMap<Integer,Integer> map)
    {
        return map.entrySet().iterator().next();
    }

}
