package jian.com.service.Impl;

import jian.com.pojo.Foo;
import jian.com.service.MytestService;

import org.springframework.stereotype.Service;

@Service
public class MytestServiceImpl implements MytestService {

    public Long mytest1(Foo foo) {
        return foo.getId();
    }

}
