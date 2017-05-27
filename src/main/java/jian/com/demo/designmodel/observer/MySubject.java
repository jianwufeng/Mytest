package jian.com.demo.designmodel.observer;

/**
 * Date: 2017年5月25日 下午5:34:52
 * 
 * @author Jihan
 * 
 */
public class MySubject extends AbstractSubject {

    // 当前主题，订阅了该主题的所有观察者都会随着该对象的变化而变化，对象之间是一种一对多的关系
    // 当一个对象变化时，其它依赖该对象的对象都会收到通知，并且随着变化！

    @Override
    public void operation() {

        System.out.println("update self!");

        notifyObservers();

    }

}
