package jian.com.demo.designmodel.observer;

/**
 * Date: 2017年5月25日 下午5:35:42
 * 
 * @author Jihan
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new ObserverImpl1());
        sub.add(new ObserverImpl2());

        sub.operation();
    }

}
