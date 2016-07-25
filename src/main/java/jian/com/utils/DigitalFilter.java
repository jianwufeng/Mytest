package jian.com.utils;

import java.util.ArrayList;
import java.util.List;

public class DigitalFilter {
    public static void main(String[] args) {
        int m;
        int max = 100;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                m = i + j;
                boolean boo = isContain(m, i, j);
                if (boo) {
                    System.out.println(i + "," + j + "," + m);
                }
            }
        }
    }

    static int filter(int temp) {
        int ws = 0; // 位数
        while (temp / 10 != 0) {
            temp /= 10;
            ws++;
        }
        return ws;
    }

    static List<Integer> filter1(int a, int m) {
        List<Integer> list = new ArrayList<Integer>();
        while (a >= 0) {
            int t;
            t = (int) (m / Math.pow(10, a));
            list.add(t);
            m = (int) (m % Math.pow(10, a));
            a--;
        }
        return list;
    }

    static boolean isContain(int m, int i, int j) {
        int a = filter(m);
        int b = filter(i);
        int c = filter(j);
        List<Integer> list1 = filter1(a, m);
        List<Integer> list2 = filter1(b, i);
        List<Integer> list3 = filter1(c, j);
        for (Integer in : list1) {
            if (list2.contains(in) || list3.contains(in)) {
                return false;
            }
        }
        return true;
    }
}
