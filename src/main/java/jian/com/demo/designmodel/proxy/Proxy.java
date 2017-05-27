package jian.com.demo.designmodel.proxy;

/**
 * Date: 2017年5月24日 下午4:45:26
 * 
 * @author Jihan
 */
public class Proxy implements Sourceable {

    private Sourceable source;

    public Proxy() {
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();

        source.method();

        atfer();
    }

    private void atfer() {
        System.out.println("after proxy!");
    }

    private void before() {
        System.out.println("before proxy!");
    }

}
