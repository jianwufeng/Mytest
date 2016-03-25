package jian.com.service.Impl;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class CglibProxyFactory implements MethodInterceptor{
    private Object target;
    
    public CglibProxyFactory(Object target){
        this.target=target;
    }
    
    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println("cglib动态代理");
        return arg1.invoke(target, arg2);
    }

    
}
