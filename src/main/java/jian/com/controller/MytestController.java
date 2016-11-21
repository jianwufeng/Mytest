package jian.com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.servlet.http.HttpServletRequest;

import jian.com.pojo.Foo;
import jian.com.service.MytestService;
import jian.com.service.Impl.MytestServiceImpl;
import jian.com.service.Impl.ProxyInvocationHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MytestController")
public class MytestController {

    private static final Logger log = LoggerFactory.getLogger(MytestController.class);

    // @Autowired
    // private MytestService mytestService;

    // @Autowired
    // private MytestService2Impl mytestService2;
    //
    // @RequestMapping("/test1")
    // public String test1(HttpServletRequest request, Foo foo) {
    // log.info("-------------------test------------------");
    // String string = mytestService2.mytest1(foo);
    // log.info("返回值 is {} ", string);
    // return "layout";
    // }

    @RequestMapping("/test2")
    public String test2(HttpServletRequest request, Foo foo) {
        log.info("-------------------test------------------");
        MytestService mytestService = (MytestService) Proxy.newProxyInstance(MytestService.class.getClassLoader(), new Class[] { MytestService.class },
                new ProxyInvocationHandler(new MytestServiceImpl()));
        String string = mytestService.mytest1(foo);
        log.info("返回值 is {} ", string);
        return "layout";
    }

    /**
     * NIO 将一个文件的所有内容拷贝到另一个文件中。 执行三个基本操作: 首先创建一个 Buffer 然后从源文件中将数据读到这个缓冲区中 最后将缓冲区写入目标文件 程序不断重复(读、写、读、写) 直到源文件结束
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String infile = "C:\\Users\\Administrator\\Desktop\\house_correct.sql";
        String outfile = "C:\\Users\\Administrator\\Desktop\\house_correct.txt";
        // 获取源文件和目标文件的输入输出流
        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        // 获取输入输出通道
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            // clear方法，重设缓冲区，使它可以接受读入的数据
            buffer.clear();
            // 从输入通道中将数据读到缓冲区
            int r = fcin.read(buffer);
            // read方法，返回读取的字节数，可能为零，如果该通道已到达流的末尾则返回-1
            if (r == -1) {
                break;
            }
            // flip方法，让缓冲区可以将新读入的数据，写入到另一个通道中
            buffer.flip();
            // 从输出通道中将数据写入缓冲区
            fcout.write(buffer);
        }
        fin.close();
        fout.close();
    }
}
