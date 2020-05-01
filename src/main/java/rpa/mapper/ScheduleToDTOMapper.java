package rpa.mapper;

import org.springframework.stereotype.Component;
import rpa.model.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleToDTOMapper {

    public EventResponseDTO map(EventEntity eventEntity) {
        return new EventResponseDTO(eventEntity.getStartTime(), eventEntity.getType(), eventEntity.getLeagueName(), mapMatch(eventEntity.getMatch()));
    }

    private MatchResponseDTO mapMatch(MatchEntity matchEntity) {
        return new MatchResponseDTO(matchEntity.getMatchId(), matchEntity.getGameCount(), mapTeams(matchEntity.getTeams()));
    }

    private List<TeamsResponseDTO> mapTeams(List<TeamEntity> teamEntities) {
        return teamEntities.stream()
                .map(t -> new TeamsResponseDTO(t.getCode(), t.getName(), t.getImage(), t.getRecordWins() != null ? t.getRecordWins() : 0, t.getRecordLosses() != null ? t.getRecordLosses() : 0))
                .collect(Collectors.toList());
    }
}
