package com.leafyun.jim.offer_11_matrix_path;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 矩阵中路径：请设计一个函数，判断矩阵是否可以包含某字符窜所有字符的路径
 * @date: 2019-02-25
 * @time: 22:47
 */
public class MatrixPath {


    /**
     * 思路：一般回溯法，首先选 0,0 为起点，即 a 为 起点，看看是否一样，不一样就往前走或者下走，每个格子都可以匹配上下左右，没有就回退
     * 需要一个 flag 数组表明哪些位置访问过
     * a b t g
     * c f c s
     * j d e h
     *
     * @param str 字符窜 bfce
     * @param arr 矩阵
     * @return 是否包含
     */
    public static boolean hasPath(String str, char[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0 || str == null) {
            return false;
        }
        char[] chars = str.toCharArray();
        int rows = arr.length;
        int cols = arr[0].length;
        // 声明一个数组，表明哪些点被访问过
        boolean[][] flag = new boolean[rows][cols];
        // 先访问第一个位置,其实是访问他的所有节点，每一个节点都要走一遍路径，只要一个节点走完路径成功，就成功
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                // 如果访问成功
                if (hasPathCore(arr, row, rows, col, cols, chars, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] arr, int row, int rows, int clo, int cols, char[] chars, int length, boolean[][] flag) {
        // 界限，当字符窜被访问完了，就完成任务
        if (length == chars.length) {
            return true;
        }
        boolean hasPath = false;
        // 如果找到了，且没被访问过，且没数组越界
        if (row >= 0 && row < rows && clo >= 0 && clo < cols && arr[row][clo] == chars[length] && !flag[row][clo] ){
            // 字符窜指针初始值为 0；找到了，字符窜指针向前一步
            length++;
            flag[row][clo] = true;
            // 上下左右找
            hasPath = hasPathCore(arr, row - 1, rows, clo, cols, chars, length, flag) ||
                    hasPathCore(arr, row+1, rows , clo, cols, chars, length, flag) ||
                    hasPathCore(arr, row, rows, clo - 1, cols, chars, length, flag) ||
                    hasPathCore(arr, row, rows, clo + 1, cols, chars, length, flag);
            // 如果找不到，退回上一格
            if (!hasPath) {
                --length;
                flag[row][clo] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        //String s = "bfch";
        String s = "bfce";
        char[][] arr = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        System.out.println(hasPath(s, arr));
    }

}
