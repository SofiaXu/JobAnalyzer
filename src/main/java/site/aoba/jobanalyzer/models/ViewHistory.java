package site.aoba.jobanalyzer.models;

import lombok.Data;

import java.util.Date;

@Data
public class ViewHistory {
    private int id;
    private int jobId;
    private Date date;
    private int times;
}
