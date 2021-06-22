package site.aoba.jobanalyzer.services;

import site.aoba.jobanalyzer.models.Job;
import site.aoba.jobanalyzer.models.ViewHistory;

public interface KafkaSendService {
    public void sendMessage(ViewHistory viewHistory);
}
