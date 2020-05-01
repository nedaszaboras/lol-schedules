package rpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import rpa.model.LeagueEntity;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueEntity, String> {
}