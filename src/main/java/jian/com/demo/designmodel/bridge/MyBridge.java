package jian.com.demo.designmodel.bridge;

/**
 * Date: 2017年5月24日 下午2:46:35
 * 
 * @author Jihan
 */
public class MyBridge extends Bridge {

    public void method() {
        getSource().method();
    }

}
