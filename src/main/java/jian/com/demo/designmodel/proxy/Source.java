package jian.com.demo.designmodel.proxy;

/**
 * Date: 2017年5月24日 下午4:44:43
 * 
 * @author Jihan
 */
public class Source implements Sourceable {

    @Override
    public void method() {

        System.out.println("the original method!");

    }

}
