package _146LRU缓存机制;

public class Test {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
//        lru.put(1,3);
//        lru.put(2,4);
//        System.out.println(lru.get(1));
//        lru.put(3,3);
//        lru.put(4,2);
//        System.out.println(lru.get(2));
//        System.out.println(lru);
//        System.out.println(lru.get(2));
//        lru.put(2,6);
//        System.out.println(lru.get(1));
//        lru.put(1,5);
//        lru.put(1,2);
//        System.out.println(lru.get(1));
//        System.out.println(lru.get(2));
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }
}
