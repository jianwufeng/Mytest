package jian.com.tracking;

public interface TrackingDetailCollectService {

    /**
     * 收集消息
     * 
     * @param messageInfo
     */
    void doBatchCollect(SyncPojo pojo, String topic);

}
