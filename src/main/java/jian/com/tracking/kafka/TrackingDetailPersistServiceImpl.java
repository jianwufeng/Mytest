package jian.com.tracking.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "trackingDetailPersistService")
public class TrackingDetailPersistServiceImpl implements TrackingDetailProcessService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doProcess(String message) {
        log.error(message);
    }

    @Override
    public void saveData() {
    }

    @Override
    public void saveTrackingData() {
    }

}
