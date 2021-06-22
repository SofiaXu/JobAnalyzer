package site.aoba.jobanalyzer.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import site.aoba.jobanalyzer.models.Job;
import site.aoba.jobanalyzer.models.ViewHistory;
import site.aoba.jobanalyzer.services.KafkaSendService;

@Service
public class KafkaSendServiceImpl implements KafkaSendService {
    private final KafkaTemplate<String, ViewHistory> template;
    private final ObjectMapper objectMapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public KafkaSendServiceImpl(KafkaTemplate<String, ViewHistory> template, ObjectMapper objectMapper) {
        this.template = template;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(ViewHistory viewHistory) {
        try {
            template.send("JobViewHistory", viewHistory);
        } catch (Exception e) {
            logger.error("Send topic error", e);
        }
    }
}
