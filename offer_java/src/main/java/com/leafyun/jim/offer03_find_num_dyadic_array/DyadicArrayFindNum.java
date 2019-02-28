package com.leafyun.jim.offer03_find_num_dyadic_array;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 从一个二维数组找数字
 * @date: 2019-02-04
 * @time: 17:57
 */

public class DyadicArrayFindNum {

    /**
     * 方法一：遍历二维数组，时间 O(n^2)
     */
    public boolean findNumFromDyadicArray() {
        return false;
    }

    /**
     * 方法二：通过具体查找例子看规律:
     * 题目二维数组为左右上下递增，比如查找 7 ，从右上角（也可以左下角）开始查询，比如第一个是 9 ，9 所在的列都比 9 大，
     * 7 比 9 小，所以排除最后一列。又是右上角，7 比 8 小，8 所在的列都比 8 大，所以只能找前两列，接下来是 2 ，7 比 2 大
     * 所以排除第一行，7 比 4 大，所以排除第二行，7 = 7 找到了。
     * ```
     * 1 2 8  9
     * 2 4 9  12
     * 4 7 10 13
     * 6 8 11 15
     */
    public static boolean findNumFromDyadicArray2(int[][] arr, int target) {
        // 判断二维数组：null，{},{{},}
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }
        // 从右上角开始查询，第 0 行, 第 3 列。
        int row = 0;
        int column = arr[0].length - 1;
        while (row < arr.length && column >= 0) {
            // 如果右上角数比 7 大，排除一列
            if (arr[row][column] == target) {
                return true;
            } else if (arr[row][column] < target) {
                row++;
            } else {
                // arr[row][column] > target
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        // int[][] arr =null;
        // int[][] arr ={};
        // int[][] arr ={{}};
        boolean result = findNumFromDyadicArray2(arr, 7);
        System.out.println("result: " + result);
    }

}
