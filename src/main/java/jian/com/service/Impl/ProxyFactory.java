package jian.com.service.Impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler{
    
    private Object target;
    
    public ProxyFactory(Object target){
        this.target=target;
    }
    
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理");
        return method.invoke(proxy, args);
    }
    
    /*public static void main(String[] args) {
        MytestService mytest = new MytestServiceImpl();
        ProxyFactory factory = new ProxyFactory(mytest);
        MytestService service  = (MytestService) factory.getProxy();
        service.mytest1();
    }*/
    
}
