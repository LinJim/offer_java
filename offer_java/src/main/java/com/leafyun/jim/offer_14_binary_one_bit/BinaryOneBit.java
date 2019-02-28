package com.leafyun.jim.offer_14_binary_one_bit;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 一个整数二进制中 1 的个数
 * @date: 2019-02-25
 * @time: 22:47
 */
public class BinaryOneBit {
    //  解法一：每次 & 1，判断最右边是不是 1 ，是就 count ++ ，然后不断右移 >>1 ，直到为 0 。缺点负数右移会发生死循环。

    // 解法二：既然负数右移会发生死循环，那我就先规定一个 1 ，让 1 不断左移，且不断和 n & 运算，就可以从右边开始判断 n 最低位是不是 1 ，次低位是不是 1 。但是循环次数和 1 的个数相等。

    // 解法三：每次 n = n&(n-1) ，每次都会消去最右边的 1 。
    public static int numOf1(int num){
        int count=0;
        while (num>0){
            num = num&(num-1);
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numOf1(15));
    }


}
