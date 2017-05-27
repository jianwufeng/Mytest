package jian.com.demo.designmodel.observer;

/**
 * Date: 2017年5月25日 下午5:31:23
 * 
 * @author Jihan
 */
public interface Subject {

    /* 增加观察者 */
    public void add(Observer observer);

    /* 删除观察者 */
    public void del(Observer observer);

    /* 通知所有的观察者 */
    public void notifyObservers();

    /* 自身的操作 */
    public void operation();

}
