package com.leafyun.jim.offer09_fibonacci;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 斐波那契数列,f(n) = f(n-1) + f(n-2) ，f(1) = 0; f(2) = 1; f(3)=1; f(4)=2;
 * @date: 2019-02-12
 * @time: 20:09
 */
public class FibonacciProblem {

    /**
     * 通过递归打印斐裂波数列第 n 项的值：f(n) = f(n-1) + f(n-2) ，f(1) = 0; f(2) = 1; f(3)=1; f(4)=2;
     * 指数级效率，因为相同的函数值被一遍遍的重复计算
     */
    public static int getFibonacciByRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFibonacciByRecursion(n - 1) + getFibonacciByRecursion(n - 2);
    }

    /**
     * 通过循环计算打印斐裂波数列第 n 项的值：f(n) = f(n-1) + f(n-2) ，f(1) = 0; f(2) = 1; f(3)=1; f(4)=2;
     * 迭代计算，构建一个数组，存储前面的值，时间效率 o(n) ，但是需要辅助空间 o(n)
     */
    public int getFibonacciByRecursion2(int n) {
        // 构建一个数组,存储前面计算的值，这个比递归效率高很多，因为递归一直在计算重复的值
        int[] fibonacci = new int[n + 1];
        if(n>=0){
            fibonacci[0] = 0;
        }
        if(n>=1){
            fibonacci[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }

    /**
     * 通过循环计算打印斐裂波数列第 n 项的值：f(n) = f(n-1) + f(n-2) ，f(1) = 0; f(2) = 1; f(3)=1; f(4)=2;
     * n-1 次效率，迭代计算，利用 1 的空间来存储前面的值，时间效率 o(n) ，辅助空间 o(1)
     */
    public int getFibonacciByRecursion3(int n) {
        if (n <= 1)
            return n;
        // 构建一个数组,存储前面计算的值，这个比递归效率高很多，因为递归一直在计算重复的值
        int fibonacci = 0;
        int fibonacci0 = 0;
        int fibonacci1 = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci = fibonacci0 + fibonacci1;
            fibonacci0 = fibonacci1;
            fibonacci1 = fibonacci;
        }
        return fibonacci;
    }

    /**
     * 可以用数学公式转换为求矩阵的 n 次方，logn 效率
     */
    public int getFibonacciByRecursion4(int n) {
        return 0;
    }



    public static void main(String[] args) {

    }

}
