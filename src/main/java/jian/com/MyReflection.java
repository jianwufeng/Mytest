package jian.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jian.com.pojo.Foo;
import jian.com.service.Fruit;


public class MyReflection {
    
    public static <T> Fruit reflectFactory(T t){
        Fruit object = null;
        try {
            object = (Fruit) Class.forName((String) t).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
    
    public static <T, E> E listConvertMap(T t,E e){
        List<E> list = new ArrayList<E>();
        list.add(e);
        
        Map<T,E> map = new HashMap<T,E>();
        for (E e2 : list) {
            map.put(t, e2);
        }
        return map.get(t);
    }
    
    public static void main(String[] args) {
        /*String name = "jian.com.service.Impl.AppleImp";
        Fruit fruit = reflectFactory(name);
        fruit.eat();*/
        Foo foo = new Foo();
        foo.setId("1");
        foo.setTitle("listConvertMap");
        Foo foo2 = listConvertMap("1", foo);
        System.out.println(foo2.getId() + foo2.getTitle());
    }
    
}
