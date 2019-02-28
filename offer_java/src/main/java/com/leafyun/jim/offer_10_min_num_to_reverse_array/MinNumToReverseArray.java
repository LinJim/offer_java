package com.leafyun.jim.offer_10_min_num_to_reverse_array;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 旋转数组的最小数字
 * @date: 2019-02-25
 * @time: 22:05
 */
public class MinNumToReverseArray {
    // 方法一：直接遍历整个数组，找出最小元素，o(n)

    /**
     * 12345 旋转为 34512 ，旋转数组的最小数字就是 1 。因为其是递增数组，在有一定的排序，可以用二分法。
     * 二分查找法：log(n)
     *
     * @param array 旋转后为 {3,4,5,1,2}
     * @return
     */
    public static int findMinNumToReverseArray(int[] array) {
        if (array == null || array.length == 0) {
            // -1 代表没找到
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        int middle = -1;
        while (low < high) {
            middle = (high - low) / 2 + low;
            // 还有一种情况：1,1,1,0,1，你就找不到哪里是递增的，因此只能顺序查找
            if (array[low] == array[middle] && array[middle] == array[high]) {
                return minInOrder(array, low, high);
            }
            // 5 > 2 ,证明中间变小了
            if (array[middle] > array[high]) {
                low = middle + 1;
            } else {
                // 否则就是一直增大，旋转数字肯定在 middle 前面
                high = middle;
            }
        }
        return array[low];
    }

    private static int minInOrder(int[] array, int low, int high) {
        int min = array[low];
        for (int i = low + 1; i <= high; i++) {
            // 选出最小的
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
//         int[] arr={3,4,5,1,2};
         int[] arr={1,1,1,0,1};
        System.out.println(findMinNumToReverseArray(arr));
    }

}
