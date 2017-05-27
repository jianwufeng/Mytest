package jian.com.utils;

/**
 * Date: 2017年1月11日 上午10:29:00
 * 
 * @author Jihan
 */
public class Recursion {

    public static void main(String[] args) {
        decimalToBinary(15);// 十进制转换二进制
        // System.out.println(sum(100));// 求和
        // yueshu(100, 80); // 求最大公约数
        // hanon(4, 'A', 'B', 'C'); // 求汉诺塔算法
        // lingxing(5);
    }

    // 递归方法decimalToBinary，把一个十进制数转换成二进制数
    public static void decimalToBinary(int num) {
        if (num == 0) { // 当num=0时，循环结束
            return;
        } else {
            decimalToBinary(num / 2); // 调用递归方法
            System.out.print(num % 2);
        }
    }

    public static int sum(int num) {
        if (num > 0) {
            return num + sum(num - 1); // 调用递归方法
        } else {
            return 0; // 当num=0时，循环结束
        }
    }

    public static void yueshu(int num1, int num2) {
        if (num1 == num2) {
            System.out.println(num1); // num1=num2时，结束
        } else {
            yueshu(abs(num1 - num2), min(num1, num2)); // 调用递归方法
        }
    }

    // 求两个数绝对值
    public static int abs(int num) {
        return num > 0 ? num : -num;
    }

    // 求两个数较小者
    public static int min(int num1, int num2) {
        return num1 > num2 ? num2 : num1;
    }

    // 递归方法hanon，求汉诺塔算法
    public static void hanon(int n, char a, char b, char c) {
        if (n == 1) {
            move(1, a, c);// 最后一种情况是，把A柱子上盘子移到C柱子上。
            return;
        }
        hanon(n - 1, a, c, b); // 递归，把n-1个盘子从A 盘上借助C盘移到B盘上
        move(n, a, c);// 调用move()方法
        hanon(n - 1, b, a, c);// 递归，把把n-1个盘子从B盘上借助A盘移到C盘上
    }

    public static void move(int n, char a, char c) {
        System.out.println(n + ":" + a + "-->" + c);// 打印移动盘子情况
    }

    // 打印出菱形
    static void lingxing(int n) {
        int i, j, k;

        // 先打印出上半部分
        for (i = 1; i <= n; i++) {

            for (j = 1; j <= n - i; j++)
                System.out.print(" "); // 打印空格

            for (k = 1; k <= 2 * i - 1; k++)
                System.out.print("*"); // 空格后打印*

            System.out.println("");// 换行

        }

        // 打印出下半部分
        for (i = 1; i <= n - 1; i++) {

            for (j = 1; j <= i; j++)
                System.out.print(" ");

            for (k = 1; k <= (2 * n - 1) - 2 * i; k++)
                System.out.print("*");

            System.out.println(""); // 换行
        }
    }
}
