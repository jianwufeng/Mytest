package jian.com.utils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestHashMap {

    private static HashMap<String, Integer> map = new HashMap<String, Integer>();

    private static ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<String, Integer>();
    private static Lock lock = new ReentrantLock();// 锁

    public static synchronized void add(String key) {
        Integer value = map.get(key);
        if (value == null) {
            map.put(key, 1);
        } else {
            map.put(key, value + 1);
        }
        System.out.println(map.get(key));
    }

    public static void add2(String key) {
        Integer value = map2.get(key);
        System.out.println(value);
        if (value == null) {
            map2.put(key, 1);
        } else {
            map2.put(key, value + 1);
        }
        System.out.println(map2.get(key) + "=====");
    }

    public static void add3(String key) {
        lock.lock();
        try {
            Integer value = map.get(key);
            System.out.println(value);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
            System.out.println(map.get(key) + "=====");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        TestHashMap ss = new TestHashMap();
        ss.test();
        // ss.testThreadPool();
        // System.out.println(h.size());
    }

    class TestThread implements Runnable {

        @Override
        public void run() {
            // add("aaa");
            // add2("aaa");
            add3("aaa");
            // addContent("aaa", "123");
        }
    }

    public void test() {
        for (int i = 0; i < 100; i++) {
            (new Thread(new TestThread())).start();
        }
    }

    public void testThreadPool() {
        ThreadPoolExecutor exec = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(89));
        for (int i = 0; i < 100; i++) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    // add("aaa");
                    // add2("aaa");
                    add3("aaa");
                    // addContent("aaa", "123");
                }
            });
        }
    }

    volatile int count; // 虽然解决了可见性，但不能解决并发问题

    static Hashtable<String, String> h = new Hashtable<String, String>();

    public void addContent(String key, String value) {
        if (count < 100) {
            h.put(key + count, value + count);
            System.out.println("key = " + key + count + ",value = " + h.get(key + count));
            count++;
        }
    }

}
