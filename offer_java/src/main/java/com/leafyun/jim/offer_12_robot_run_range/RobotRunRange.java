package com.leafyun.jim.offer_12_robot_run_range;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 机器人运动范围：不能进入行坐标和纵坐标之和大于 k 的人，求最多能到达多少格子
 * @date: 2019-02-25
 * @time: 22:47
 */
public class RobotRunRange {

    // 此题也是回溯法，从起始点开始计数，为 1 ，然后加上下左右
    //(0,0) (0,1) (0,2)
    //(1,0) (1,1) (1,2)
    //(2,0) (2,1) (2,2)
    public int getMovingCount(int rows, int cols, int threshold) {
        // 先检验数据合法
        if (rows <= 0 || cols <= 0 || threshold < 0) {
            return 0;
        }
        // 记录格子是否被访问
        boolean[][] flag = new boolean[rows][cols];
        // 计算格子数,因为要递归，所以另起方法，先访问 0 行 0 列
        int count = movingCount(0, rows, 0, cols, threshold, flag);
        return count;
    }

    private int movingCount(int row, int rows, int col, int cols, int threshold, boolean[][] flag) {
        int count = 0;
        // 如果此行此列没有被访问过，且小于 threshold
        if (check(row, rows, col, cols, threshold, flag)) {
            // 设置此点被访问过
            flag[row][col] = true;
            // 从起始点开始计数，为 1 ，然后加上下左右
            count = 1 + movingCount(row - 1, rows, col, cols, threshold, flag) +
                    movingCount(row + 1, rows, col, cols, threshold, flag) +
                    movingCount(row, rows, col - 1, cols, threshold, flag) +
                    movingCount(row, rows, col + 1, cols, threshold, flag);
        }
        return count;
    }

    /**
     * 检验此格子是否有被访问过，且小于 threshold
     */
    private boolean check(int row, int rows, int col, int cols, int threshold, boolean[][] flag) {
        // 果此行此列没有被访问过，且行坐标和纵坐标只之和小于 threshold
        if (row >= 0 && row < rows && col >= 0 && col < cols && !flag[row][col] && (getDigitSum(row) + getDigitSum(col) <= threshold)) {
            return true;
        }
        return false;
    }

    // 计算一个数位数之和,比如 18
    private int getDigitSum(int num) {
        // 计算一个数位数之和,比如 18
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        RobotRunRange robot = new RobotRunRange();
        System.out.println(robot.getMovingCount(3, 3, 2));
    }


}
