package com.leafyun.jim.offer04_replace_all_blank;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 给出一个字符窜，替换所有的空格为 %20：we are happy
 * @date: 2019-02-06
 * @time: 12:54
 */
public class ReplaceAllBlank {

    // 方法一：String.split("") 分割多个 we are happy ,然后再用 stringbuilder 添加每个字符窜和添加 %20 ，最后一个不要添加 %20
    public void replaceBlank1() {
        String s = "we are happy";
        //s.split();
    }

    // 方法二：String.replaceAll("")
    public void replaceBlank2() {
        String s = "we are happy";
        //s.split();
    }

    // 方法三：就是直接遍历字符窜，遇到空格，就让后面的字符向后移动 2 位，但是这种方法，一个空格，要移 O(n) 个字符，n 个空格，时间效率 O(n^2)
    public void replaceBlank3() {

    }

    /**
     * 方法四：
     * 1. 遍历字符窜，得到新的替换的长度，空格的话，因为要替换 %20，所以增加两个长度，所以新长度为旧长度 + 空格数量 * 2 ,但是 java 的话，是不用计算字符窜长度的
     * 2. 设置两个指针，p1 指针在原字符窜，p2 指针在扩容字符窜
     * 3. p1 向前走一格，如果 p1 遇到的不是空格，，p2 也向前走一格，如果 p1 遇到的是空格，p2 就直接走三格，直到 p1 p2 相遇。
     *
     * @param str
     */
    public static String replaceBlank4(StringBuffer str) {
        // 原来字符窜指针
        int p1 = str.length() - 1;
        // 本来计算空格数量，再新长度为旧长度 + 空格数量 * 2，但是 java 是直接得到长度
        // 这步用来直接扩容到多大的数组，用空格来占位,每遇到一个空格，增加两个长度
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                // 因为要替换，所以增加两个空格
                str.append("  ");
            }
        }
        // 新的字符窜指针
        int p2 = str.length() - 1;
        while (p1 != p2) {
            // 空格替换为 %20
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
        // StringBuffer str = new StringBuffer("");
        // StringBuffer str = new StringBuffer(" ");
        // StringBuffer str = new StringBuffer("        ");
        System.out.println(replaceBlank4(str));
    }

}
