package site.aoba.jobanalyzer.models;

import lombok.Data;

import java.util.Date;

@Data
public class Job {
    private int id;
    private double salary;
    private int educationId;
    private int positionId;
    private int locationId;
    private int requirement;
}
