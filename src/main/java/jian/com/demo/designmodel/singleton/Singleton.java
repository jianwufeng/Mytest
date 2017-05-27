package jian.com.demo.designmodel.singleton;

/**
 * Date: 2017年5月24日 下午5:22:48
 * 
 * @author Jihan
 */
public class Singleton {

    // 单例对象（Singleton）是一种常用的设计模式。在Java应用中，单例对象能保证在一个JVM中，该对象只有一个实例存在。这样的模式有几个好处：

    // 1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
    //
    // 2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力。
    //
    // 3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程。

    // 懒汉模式
    private static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // 由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例，但是instance已经不为null了）
        }
        return instance;
    }

    // 内部类实线
    // 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Singleton instance1 = new Singleton();
    }

    /* 获取实例 */
    public static Singleton getInstance1() {
        return SingletonFactory.instance1;
    }

    public static void main(String[] args) {
        // Singleton.getInstance1();

        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {

                @Override
                public void run() {
                    Singleton.getInstance();
                }
            }).start();
        }
    }
}
