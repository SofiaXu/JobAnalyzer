package site.aoba.jobanalyzer.repositories;

import org.springframework.stereotype.Repository;
import site.aoba.jobanalyzer.models.Job;

import java.util.List;

@Repository
public interface JobRepository {
    public List<Job> getJobs();
    public void addJobs(List<Job> jobs);
}
