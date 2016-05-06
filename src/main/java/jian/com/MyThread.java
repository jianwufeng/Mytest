package jian.com;

import java.util.concurrent.ConcurrentLinkedDeque;

public class MyThread implements Runnable {

    private static ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<String>(); // 非阻塞安全队列

    public MyThread(ConcurrentLinkedDeque<String> list) {
        MyThread.setList(list);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        while (true) {
            String pop = null;
            try {
                pop = getList().pollFirst(); // 获取并移除此队列的头，如果此队列为空，则返回 null。
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (null != pop) {
                System.out.println("====" + name + "====" + pop);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();// 创建一个非阻塞安全队列
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        Thread threads[] = new Thread[10]; // 创建一个存储10个Thread对象的数组threads
        for (int i = 0; i < threads.length; i++) {
            MyThread task = new MyThread(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d MyThread threads have been launched\n", threads.length);

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: Size of the List: %d\n", list.size());
    }

    public static ConcurrentLinkedDeque<String> getList() {
        return list;
    }

    public static void setList(ConcurrentLinkedDeque<String> list) {
        MyThread.list = list;
    }

}
