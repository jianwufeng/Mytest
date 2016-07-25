package jian.com.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOr2ForTest {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 1; i++) {
            list1.add(i);
            list2.add(i);
            map.put(i, "a" + i);
        }
        long startTime = System.currentTimeMillis();
        for (Integer m : list1) {
            for (Integer n : list2) {
                if (m == n) {
                    // System.out.println(m);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("===" + time);
        long startTime1 = System.currentTimeMillis();
        for (Integer integer : list2) {
            map.get(integer);
        }
        long endTime1 = System.currentTimeMillis();
        long time1 = endTime1 - startTime1;
        System.out.println(time1);
    }

}
