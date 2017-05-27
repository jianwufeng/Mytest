package jian.com.demo.designmodel.decorator;

/**
 * Date: 2017年5月24日 下午5:04:35
 * 
 * @author Jihan
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }

}
