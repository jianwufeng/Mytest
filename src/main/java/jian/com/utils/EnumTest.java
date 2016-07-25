package jian.com.utils;

public enum EnumTest {
    PLUS {
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        public double eval(double x, double y) {
            return x / y;
        }
    };
    public abstract double eval(double x, double y);// 位置1，此处为枚举类定义了一个抽象方法

    public static void main(String[] args) {
        System.out.println(EnumTest.PLUS.eval(3, 4));
        System.out.println(EnumTest.MINUS.eval(5, 4));
        System.out.println(EnumTest.TIMES.eval(5, 4));
        System.out.println(EnumTest.DIVIDE.eval(5, 4));
    }
}
