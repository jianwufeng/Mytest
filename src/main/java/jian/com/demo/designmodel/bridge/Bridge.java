package jian.com.demo.designmodel.bridge;

/**
 * Date: 2017年5月24日 下午2:45:40
 * 
 * @author Jihan
 */
public abstract class Bridge {

    private Sourceable source;

    public void method() {
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }

}
