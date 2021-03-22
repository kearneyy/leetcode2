package _925长按键入;

class Solution2 {
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {//如果相等
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {//如果不相等，但是j和前一个字符相同
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        boolean longPressedName = isLongPressedName("pyplrz", "ppyypllr");
        System.out.println(longPressedName);
    }
}