package site.aoba.jobanalyzer.di;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {
    @Bean
    public NewTopic provideTopic() {
        return TopicBuilder.name("JobViewHistory")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
