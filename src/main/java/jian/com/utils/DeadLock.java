package jian.com.utils;

//
//import java.util.HashMap;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class DeadLock {
//
//    private static HashMap<String, Integer> map = new HashMap<String, Integer>();
//
//    private static Lock lock1 = new ReentrantLock();
//
//    private static Lock lock2 = new ReentrantLock();
//
//    public static void add3(String key) {
//        lock1.lock();
//        lock2.lock();
//        try {
//            Integer value = map.get(key);
//            System.out.println(value);
//            if (value == null) {
//                map.put(key, 1);
//            } else {
//                map.put(key, value + 1);
//            }
//            System.out.println(map.get(key) + "=====");
//            add4(key);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock1.unlock();
//            lock2.unlock();
//        }
//
//    }
//
//    public static void add4(String key) {
//        lock2.lock();
//        lock1.lock();
//        try {
//            Integer value = map.get(key);
//            System.out.println(value);
//            if (value == null) {
//                map.put(key, 1);
//            } else {
//                map.put(key, value + 1);
//            }
//            System.out.println(map.get(key) + "=====");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock2.unlock();
//            lock1.unlock();
//        }
//
//    }
//
//    class TestThread implements Runnable {
//
//        @Override
//        public void run() {
//            add3("aaa");
//        }
//    }
//
//    class TestThread1 implements Runnable {
//
//        @Override
//        public void run() {
//            add3("aaa");
//        }
//    }
//
//    public void test1() {
//        (new Thread(new TestThread())).start();
//    }
//
//    public void test2() {
//        (new Thread(new TestThread1())).start();
//    }
//
//    public static void main(String[] args) {
//        DeadLock deadLock = new DeadLock();
//        deadLock.test1();
//        deadLock.test2();
//    }
// }
public class DeadLock implements Runnable {
    public int flag = 1;
    // 静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {

        DeadLock td1 = new DeadLock();
        DeadLock td2 = new DeadLock();
        td1.flag = 1;
        td2.flag = 0;
        // td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        // td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();

    }
}
