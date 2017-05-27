package jian.com.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2017年5月8日 上午9:49:52
 * 
 * @author Jihan
 */
public class ThreadLocalManager {

    private static ThreadLocal<HashMap<?, ?>> pool = new ThreadLocal<HashMap<?, ?>>();

    public static Object get(String key) {

        Map<?, ?> map = (Map<?, ?>) pool.get();
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    public static void add(String key, Object value) {

        if (pool.get() == null) {
            pool.set(new HashMap<String, Object>());
        }
        Map<String, Object> map = (Map<String, Object>) pool.get();
        map.put(key, value);
    }

    public static Map<?, ?> getMap() {

        return (Map<?, ?>) pool.get();
    }

    public static void clear() {

        pool.set(null);
    }

    public static void main(String[] args) {

        BlockingQueue<Runnable> bloceQueue = new LinkedBlockingDeque<Runnable>(5);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES, bloceQueue);
        pool.submit(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

            }
        });
    }
}
