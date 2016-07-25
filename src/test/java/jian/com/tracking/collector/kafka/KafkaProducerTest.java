package jian.com.tracking.collector.kafka;

import jian.com.controller.MytestController;
import jian.com.tracking.TrackingDetailCollectService;
import jian.com.tracking.impl.TrackingDetailCollectServiceImpl;
import jian.com.tracking.kafka.constants.TrackingMessageInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml" })
public class KafkaProducerTest {

    private static final Logger log = LoggerFactory.getLogger(MytestController.class);

    /*
     * Logger log = LoggerFactory.getLogger(this.getClass()); public static String topics = "xxx"; public static
     * Map<String, KafkaProducer> kafkaProducers = new HashMap<String, KafkaProducer>(); public static Map<String,
     * List<String>> msgList = new HashMap<String, List<String>>();
     */

    private TrackingDetailCollectService trackingDetailCollectService;

    @Before
    public void setUp() {
        trackingDetailCollectService = new TrackingDetailCollectServiceImpl();
    }

    @Test
    public void testCollect() {
        TrackingMessageInfo messageInfo = new TrackingMessageInfo();
        messageInfo.setBrowser("firefox");
        messageInfo.setIp("10.10.10.190");
        messageInfo.setUserId("27757");
        messageInfo.setCookieId("6D8419EACB");
        messageInfo.setUrl("http://item.meitun.com/itemDetail-1785-33010100070115.htm"); // 2015-05-27 10:51
        // messageInfo.setUrl("http://item.meitun.com/itemDetail-1780-33010100070110.htm");
        // messageInfo.setUrl("http://172.16.1.65/");
        messageInfo.setSubOrderCode("1115040324903338");
        messageInfo.setUserId("adcdcss");
        messageInfo.setReferrer("http://m.meitun.com/cmphtml/pages/product_details.html?specialid=1759&productid=13010300260101&code=555f0057a4026");
        messageInfo.setSessionId("122456789");
        messageInfo.setLogEvent(1);
        log.info("brokerList={}", "brokerList");
        for (int i = 0; i < 2; i++) {
            trackingDetailCollectService.doBatchCollect(messageInfo, "tracking-detail-0");
        }
    }
}
