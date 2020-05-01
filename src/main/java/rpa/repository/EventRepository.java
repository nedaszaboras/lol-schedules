package rpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rpa.model.EventEntity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

//    @Query(value = "SELECT e FROM EventEntity e where e.startTime between :startTime AND :endTime")
    List<EventEntity> findAllByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
