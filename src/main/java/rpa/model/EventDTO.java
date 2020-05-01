package rpa.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDTO {
    private LocalDateTime startTime;
    private String state;
    private String type;
    private MatchDTO match;
    private LeagueDTOs league;
}
