package jian.com.service.Impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import jian.com.pojo.Foo;
import jian.com.service.MytestService;

public class ProxyInvocationHandler implements InvocationHandler {

    private Object proxyedObject;

    public ProxyInvocationHandler(Object proxyedObject) {
        this.proxyedObject = proxyedObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();

        if (proxy instanceof MytestService && method.getName().equals("mytest1")) {
            System.out.println("=============动态代理==============");
        }

        Object result = method.invoke(proxyedObject, args);

        doAfter();

        return result;
    }

    private void doBefore() {
        System.out.println("before method invoke");
    }

    private void doAfter() {
        System.out.println("after method invoke");
    }

    public static void main(String[] args) {
        MytestService mytestService = (MytestService) Proxy.newProxyInstance(MytestService.class.getClassLoader(), new Class[] { MytestService.class },
                new ProxyInvocationHandler(new MytestServiceImpl()));
        mytestService.mytest1(new Foo());
    }

}
