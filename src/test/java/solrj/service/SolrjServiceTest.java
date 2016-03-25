package solrj.service;

import java.util.Arrays;
import java.util.List;

import jian.com.pojo.Foo;
import jian.com.service.MytestService;
import jian.com.service.SolrjService;
import jian.com.service.Impl.MytestServiceImpl;
import jian.com.service.Impl.ProxyFactory;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.junit.Before;
import org.junit.Test;

public class SolrjServiceTest {

    private SolrjService solrjService;

    @Before
    public void setUp() throws Exception {
        // 在url中指定core名称：taotao
        String url = "http://localhost:8983/solr/taotao";
        HttpSolrServer httpSolrServer = new HttpSolrServer(url); //定义solr的server
        httpSolrServer.setParser(new XMLResponseParser()); // 设置响应解析器
        httpSolrServer.setMaxRetries(1); // 设置重试次数，推荐设置为1
        httpSolrServer.setConnectionTimeout(500); // 建立连接的最长时间

        solrjService = new SolrjService(httpSolrServer);
    }

    @Test
    public void testAdd() throws Exception {
        Foo foo = new Foo();
        foo.setId(System.currentTimeMillis() + "");
        foo.setTitle("轻量级Java EE企业应用实战（第3版）：Struts2＋Spring3＋Hibernate整合开发（附CD光盘）");

        this.solrjService.add(foo);
    }

    @Test
    public void testDelete() throws Exception {
        this.solrjService.delete(Arrays.asList("1312313"));
    }

    @Test
    public void testSearch() throws Exception {
        List<Foo> foos = this.solrjService.search("Java", 1, 10);
        for (Foo foo : foos) {
            System.out.println(foo);
        }
    }
    
    @Test
    public void testJDK(){
        MytestService mytest = new MytestServiceImpl();
        ProxyFactory factory = new ProxyFactory(mytest);
        MytestService service  = (MytestService) factory.getProxy();
        service.mytest1();
    }
    
    @Test
    public void testInterface(){
        MytestService mytest = new MytestServiceImpl();
        mytest.mytest1();
    }

}
