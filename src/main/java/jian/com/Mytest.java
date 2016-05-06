package jian.com;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class Mytest {
    // test
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper("192.168.10.128:2182", 3000, new DemoWatcher());// 连接zk server
        String node = "/app1";
        Stat stat = zk.exists(node, false);// 检测/app1是否存在
        if (stat == null) {
            // 创建节点
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        // 获取节点的值
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }

    static class DemoWatcher implements Watcher {
        public void process(WatchedEvent event) {
            System.out.println("----------->");
            System.out.println("path:" + event.getPath());
            System.out.println("type:" + event.getType());
            System.out.println("stat:" + event.getState());
            System.out.println("<-----------");
        }
    }

}
