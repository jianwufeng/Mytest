package jian.com.demo.designmodel.observer;

/**
 * Date: 2017年5月25日 下午5:30:20
 * 
 * @author Jihan
 */
public class ObserverImpl1 implements Observer {

    @Override
    public void update() {

        System.out.println("observer1 has received!");

    }

}
