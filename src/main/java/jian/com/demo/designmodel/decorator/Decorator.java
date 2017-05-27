package jian.com.demo.designmodel.decorator;

/**
 * Date: 2017年5月24日 下午5:00:23
 * 
 * @author Jihan
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");

    }

}
