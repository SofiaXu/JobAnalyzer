package site.aoba.jobanalyzer.repositories;

import org.springframework.stereotype.Repository;
import site.aoba.jobanalyzer.models.Location;

import java.util.List;

@Repository
public interface LocationRepository {
    public List<Location> getLocations();
}
