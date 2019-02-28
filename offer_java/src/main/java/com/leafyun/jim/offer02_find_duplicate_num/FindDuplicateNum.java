package com.leafyun.jim.offer02_find_duplicate_num;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 找数组中任意一个重复数字：一个长度为 n 的数组里面，数字大小都在 0-n-1
 * @date: 2019-01-28
 * @time: 10:31
 */
public class FindDuplicateNum {

    /**
     * 直接排序，判断相邻元素相等（arr[i]=arr[i+1]）
     * 时间 o(nlogn)，空间 O（1）
     *
     * @param arr 例子数组：{2,3,1,0,2,5,3,7}
     * @return 一个重复数字
     */
    public static int findDuplicateNum01(int[] arr) {
        return -1;
    }

    /**
     * 哈希表计数，直接将数组数字填到哈希表的相应索引处，出现一次就 ++
     * 时间 o(n)，空间 O（n）
     *
     * @param arr 例子数组：{2,3,1,0,2,5,3,7}
     * @return 一个重复数字
     */
    public static int findDuplicateNum02(int[] arr) {
        return -1;
    }

    /**
     * 数组中数字和相应索引处交换，如果和相应索引处的值相等，就重复
     * 时间 o(n)，空间 O（1）
     *
     * @param arr 例子数组：{2,3,1,0,2,5,3,7}
     * @return 一个重复数字
     */
    public static int findDuplicateNum03(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            // 如果数字和相应索引不相等，就和 arr[数字] 交换
            while (arr[i] != i) {
                // 如果数字和相应索引处的值刚好相等，就重复,返回重复值
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                // 交换
                swap(arr, i, arr[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 二分查找法，查找 [0,(n-1)/2] ,[(n-1)/2,n] 数组出现的个数，如果个数比正常个数大，证明区间有重复数字
     * 时间 o(nlogn)，空间 O（1）
     *
     * @param arr 例子数组：{2,3,1,0,2,5,3,7}
     * @return 一个重复数字
     */
    public static int findDuplicateNum04(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0;
        int height = arr.length - 1;
        while (low <= height) {
            int middle = low + ((height - low) >> 1);
            // 计算区间出现的数目个数
            int count = count(arr, low, middle);
            // 当 low==height 的时候，只有一个数，正常值是出现一次，如果 count 计算出出现多次，就重复
            if (low == height) {
                if (count > 1) {
                    return low;
                } else {
                    break;
                }
            }
            // 如果区间出现的数目个数大于正常值，就重复
            if (count > (middle - low + 1)) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    private static int count(int[] arr, int low, int middle) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= low&& arr[i] <=middle) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3, 7};
//        int[] arr={};
//        int[] arr=null;
//        int[] arr={2,3,1,0};
        System.out.println(findDuplicateNum04(arr));
    }

}
