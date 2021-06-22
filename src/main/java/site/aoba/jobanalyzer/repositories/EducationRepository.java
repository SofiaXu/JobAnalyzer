package site.aoba.jobanalyzer.repositories;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import site.aoba.jobanalyzer.models.Education;

import java.util.List;

@Repository
public interface EducationRepository {
    public List<Education> getEducations();
}