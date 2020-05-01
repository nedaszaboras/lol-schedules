package rpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MatchResponseDTO {
    private String matchId;
    private Integer gameCount;
    private List<TeamsResponseDTO> teams;
}
