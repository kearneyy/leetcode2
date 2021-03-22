package _925长按键入;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * 925. 长按键入
 * 难度
 * 简单
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 */
class Solution {
    public static boolean isLongPressedName(String name, String typed) {
        if(typed==null||typed.length()==0)
        {
            return name == null || name.length() == 0;
        }
        int nameindex=0;
        int typedindex=0;
        while (nameindex<name.length()&&typedindex<typed.length())
        {
            char namechar = name.charAt(nameindex);
            int namenum=1;
            while (nameindex+namenum<name.length()&&namechar==name.charAt(nameindex+namenum))
            {
                namenum++;
            }
            char typedchar = typed.charAt(typedindex);
            if(typedchar!=namechar)
                return false;
            int typednum=1;
            while (typedindex+typednum<typed.length()&&typedchar==typed.charAt(typednum+typedindex))
            {
                typednum++;
            }
            if(typednum<namenum)
                return false;
            nameindex+=namenum;
            typedindex+=typednum;
        }
        if(nameindex<name.length())
            return false;
        if(typedindex<typed.length())
        {
            if(name.charAt(name.length()-1)!=typed.charAt(typedindex))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean longPressedName = isLongPressedName("alex", "alexxr");
        System.out.println(longPressedName);
    }
}