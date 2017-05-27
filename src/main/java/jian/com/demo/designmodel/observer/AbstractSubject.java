package jian.com.demo.designmodel.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Date: 2017年5月25日 下午5:32:12
 * 
 * @author Jihan
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()) {
            enumo.nextElement().update();
        }
    }

}
