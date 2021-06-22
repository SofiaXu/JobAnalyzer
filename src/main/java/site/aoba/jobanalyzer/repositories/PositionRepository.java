package site.aoba.jobanalyzer.repositories;

import org.springframework.stereotype.Repository;
import site.aoba.jobanalyzer.models.Position;

import java.util.List;

@Repository
public interface PositionRepository {
    public List<Position> getPositions();
}
