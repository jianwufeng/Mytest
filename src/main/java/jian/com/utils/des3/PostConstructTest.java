package jian.com.utils.des3;

import javax.annotation.PostConstruct;

@SuppressWarnings("restriction")
public class PostConstructTest {
    @PostConstruct
    public void init() {
        System.out.println("asc");
    }

}
