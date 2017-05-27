package jian.com.demo.designmodel.proxy;

/**
 * Date: 2017年5月24日 下午4:48:40
 * 
 * @author Jihan
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }

}
