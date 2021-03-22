package _93复原ip地址;

/**
 * 93. 复原IP地址
 * 难度
 * 中等
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */

//回溯算法，在树上深度优先遍历
/**
 * 回溯算法事实上就是在一个树形问题上做深度优先遍历，因此首先需要把问题转换为树形问题。这里请大家一定要拿起纸和笔，模拟一下如何通过指定的字符串 s 生成 IP 地址的过程，把树形图画出来（这一点很重要）。
 * 下面这张图我没有画完（如果画完，枝叶太多），请读者尽量不看我画的这张图，自己动手尝试一下这个问题的树形图应该怎么画。
 * 在画树形图的过程中，你一定会发现有些枝叶是没有必要的，把没有必要的枝叶剪去的操作就是剪枝，在代码中一般通过 break 或者 contine 和 return （表示递归终止）实现。
 *
 * 分析剪枝条件（下面只写出一些我想到的要点，有些点能想到，但是编码很复杂，我就没有写了）：
 * 1、一开始，字符串的长度小于 4 或者大于 12 ，一定不能拼凑出合法的 ip 地址（这一点可以一般化到中间结点的判断中，以产生剪枝行为）；
 * 2、每一个结点可以选择截取的方法只有 3 种：截 1 位、截 2 位、截 3 位，因此每一个结点可以生长出的分支最多只有 3 条分支；
 * 根据截取出来的字符串判断是否是合理的 ip 段，这里写法比较多，可以先截取，再转换成 int ，再判断。我采用的做法是先转成 int，是合法的 ip 段数值以后，再截取。
 * 3、由于 ip 段最多就 4 个段，因此这棵三叉树最多 4 层，这个条件作为递归终止条件之一；
 * 4、每一个结点表示了求解这个问题的不同阶段，需要的状态变量有：
 *
 * splitTimes：已经分割出多少个 ip 段；
 * begin：截取 ip 段的起始位置；
 * path：记录从根结点到叶子结点的一个路径（回溯算法常规变量，是一个栈）；
 * res：记录结果集的变量，常规变量。
 *
 *
 * 总结：这个问题思想不难，但是细节比较繁琐，什么时候递归终止，如何手动截取字符串，再转换成 int 类型，还有如何在中间结点发现可以剪枝，这些细节需要在编码的时候考虑清楚。
 *
 * 有一些编码细节写在代码注释中，供大家参考，可能还有漏掉的地方，欢迎大家给出意见。我给出的代码执行时间也不是很好。
 *
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public static List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        // 如果长度不够，不搜索
        if (len < 4 || len > 12) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        int splitTimes = 0;
        dfs(s, len, splitTimes, 0, path, res);
        return res;
    }

    /**
     * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段
     * 判断的同时顺便把类型转了
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int judgeIfIpSegment(String s, int left, int right) {
        int len = right - left + 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }

    private static void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (split == 4) {
                res.add(String.join(".", path));//把字符串都连起来
            }
            return;
        }

        // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
        if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {//前面是如果每个数取1不够分，后面是如果每个数取3分不完
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }

            int ipSegment = judgeIfIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                // 在判断是 ip 段的情况下，才去做截取
                path.addLast(ipSegment + "");
                dfs(s, len, split + 1, begin + i + 1, path, res);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("25525511135");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
