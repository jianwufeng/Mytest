package jian.com.utils;

import java.util.HashSet;
import java.util.Set;

public class RevertArr {

    public static void main(String[] args) {
        for (int i = 1; i < 100000; i++) {
            for (int j = 1; j < 10; j++) {
                int m = i * j;
                String s = m + "";
                String r = new StringBuffer(s).reverse().toString();
                if ((i + "").equals(r)) {
                    Set<Integer> set = new HashSet<Integer>();
                    for (int aa = 0; aa < r.length(); aa++) {
                        String string = r.substring(aa, aa + 1);
                        set.add(Integer.valueOf(string));
                    }
                    if (r.length() == set.size() && set.size() == 5) {
                        System.out.println("i=" + i + ",j=" + j + ",m=" + m);
                    }
                }
            }
        }
    }
}
