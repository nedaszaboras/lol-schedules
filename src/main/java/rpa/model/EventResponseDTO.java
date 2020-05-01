package rpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EventResponseDTO {
    private LocalDateTime startTime;
    private String type;
    private String leagueName;
    private MatchResponseDTO match;

}
