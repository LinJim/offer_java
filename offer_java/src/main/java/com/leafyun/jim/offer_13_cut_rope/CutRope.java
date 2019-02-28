package com.leafyun.jim.offer_13_cut_rope;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 剪绳子，每一段最大乘积
 * @date: 2019-02-25
 * @time: 22:47
 */
public class CutRope {
    // 动态规划法，每一次都有最大值，最后也有最大值：fn=max(f(i) * f(n-i))
    public static int cutRope(int length) {
        // 先举例小的情况
        if (length <= 1) {
            return 0;
        }
        // 1 * 1
        if (length == 2) {
            return 1;
        }
        // 1 * 2
        if (length == 3) {
            return 2;
        }
        // 申请一个数组来存储最优解
        int[] products = new int[length + 1];
        // 存储小的最优解,注意这个是存储每一段的最优解，即是大于 4 之后，你只能切 1 2 3 段
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        // 从第四个数组位置开始计算
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = products[j] * products[i - j];
                if (max < temp) {
                    max = temp;
                }
            }
            products[i] = max;
        }
        // 每次不断计算存储到数组中
        return products[length];
    }

    // 贪婪算法：数学原理，每次都按照 3 来切块就好了，当剩下长度为 4 时，2 * 2 反而最大
    public static int cutRope2(int length) {
        // 先举例小的情况
        // 先举例小的情况
        if (length <= 1) {
            return 0;
        }
        // 1 * 1
        if (length == 2) {
            return 1;
        }
        // 1 * 2
        if (length == 3) {
            return 2;
        }
        // 每次都按照 3 来切块，当剩下长度为 4 时，2 * 2 反而最大
        int timesOfThree = length / 3;
        // 也就是说当剩下长度为 4 时，把按照 3 来切块的次数减 1 ，回退，然后 2 * 2
        if (length - timesOfThree * 3 == 1) {
            timesOfThree--;
        }
        int timesOfTwo = (length - timesOfThree * 3) / 2;
        return (int) (Math.pow(3, timesOfThree) * Math.pow(2, timesOfTwo));
    }

    public static void main(String[] args) {
        System.out.println(cutRope(8));
        System.out.println(cutRope2(8));
    }


}
