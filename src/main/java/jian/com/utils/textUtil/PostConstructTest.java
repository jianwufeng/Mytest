package jian.com.utils.textUtil;

import javax.annotation.PostConstruct;

@SuppressWarnings("restriction")
public class PostConstructTest {
    @PostConstruct
    public void init() {
        System.out.println("asc");
    }

}
