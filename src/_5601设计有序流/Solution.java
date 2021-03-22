package _5601设计有序流;

import java.util.ArrayList;
import java.util.List;

/**
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 * 实现 OrderedStream 类：
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 * 否则，返回一个空列表。
 *
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * 输出
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 *
 * 解释
 * OrderedStream os= new OrderedStream(5);
 * os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
 * os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
 * os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
 * os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
 * os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
 */


class OrderedStream {
    static String[] str;
    static int ptr = 1;
    public OrderedStream(int n) {
        str = new String[n+1];
//        for (int i = 0; i < n+1; i++) {
//            str[i]="";
//        }
    }

    public static List<String> insert(int id, String value) {
        str[id]=value;
        List<String> list = new ArrayList<>();
        if(ptr==id)
        {

            int temp = ptr;
            while (temp<str.length-1&&str[temp+1]!=null)
            {
                list.add(str[temp]);
                temp++;
            }
            list.add(str[temp]);
            ptr=temp+1;
        }
        return list;
    }

    /**
     *
     ["OrderedStream","insert","insert","insert","insert","insert","insert","insert","insert","insert"]
     [[9],[9,"nghbm"],[7,"hgeob"],[6,"mwlrz"],[4,"oalee"],[2,"bouhq"],[1,"mnknb"],[5,"qkxbj"],[8,"iydkk"],[3,"oqdnf"]]
     * @param args
     */
    public static void main(String[] args) {
        OrderedStream os  =new OrderedStream(9);
        List<String> l1 = os.insert(9, "nghbm");// 插入 (3, "ccccc")，返回 []
        List<String> l3 =os.insert(7, "hgeob"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        List<String> l4 =os.insert(6, "mwlrz"); // 插入 (5, "eeeee")，返回 []
        List<String> l5 =os.insert(4, "oalee"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        List<String> l6 =os.insert(2, "bouhq"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        List<String> l7 =os.insert(1, "mnknb"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        List<String> l8 =os.insert(5, "qkxbj"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        List<String> l9 =os.insert(8, "iydkk"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        List<String> l10 =os.insert(3, "oqdnf"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        System.out.println(str);
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */