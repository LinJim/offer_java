package com.leafyun.jim.offer_15_power_num__n;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 数值的整数次方
 * @date: 2019-02-25
 * @time: 22:47
 */
public class PowerNumN {
    // 解法一：求数值的整数 n 次方，那只需要一个循环，base=base*base; 循环 n 次，注意底数是 0 ，指数是负数情况即没意义，以及底数是正数，指数负数，要先求绝对值，然后再 1/绝对值


    // 解法二：利用递归方法，n 为偶数时，a^n=a^(n/2)*a^(n/2);n 为奇数时，a^n=a^[(n-1）/2] *a^[(n-1）/2]*a;
    // 需要考虑: 指数负数，要先求绝对值，然后再 1/绝对值
    public static double powerNumN(double num, int exponent) {
        boolean flag = false;
        // 递归结束条件
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return num;
        }
        // 处理指数为负数，要先求绝对值，然后再 1/绝对值
        if (exponent < 0) {
            exponent = -exponent;
            flag = true;
        }
        // 否则就递归,求出 a^(n/2)
        double result = powerNumN(num, exponent / 2);
        result = result * result;
        // 如果是奇数,exponent % 2 == 1，再乘以一个 num
        if ((exponent & 1) == 1) {
            result = result * num;
        }
        return flag ? 1 / result : result;
    }


    public static void main(String[] args) {
        System.out.println(powerNumN(2.0, 3));
        System.out.println(powerNumN(2.0, -3));
        System.out.println(powerNumN(0.0, 3));
        System.out.println(powerNumN(0.0, -3));
        System.out.println(powerNumN(-2.0, 3));

    }


}
