package rpa.mapper;

import org.springframework.stereotype.Component;
import rpa.model.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ScheduleDTOToEntityMapper {

    public EventEntity map(EventDTO eventDTO) {
        EventEntity event = EventEntity.builder()
                .startTime(eventDTO.getStartTime())
                .type(eventDTO.getType())
                .match(eventDTO.getMatch() != null ? mapMatch(eventDTO.getMatch()) : null)
                .leagueName(eventDTO.getLeague().getName())
                .build();
        if (event.getMatch() != null) {
            event.getMatch().setEvent(event);
        }
        return event;
    }

    private List<TeamEntity> mapTeams(List<TeamDTO> teamDTOS) {
        return teamDTOS.stream().map(t ->
             TeamEntity.builder()
                     .code(t.getCode())
                     .name(t.getName())
                     .image(t.getImage())
                     .recordWins(t.getRecord() != null && t.getRecord().getWins() != null ? t.getRecord().getWins() : null)
                     .recordLosses(t.getRecord() != null && t.getRecord().getLosses() != null ? t.getRecord().getLosses() : null)
                     .build())
                .collect(Collectors.toList());
    }

    private MatchEntity mapMatch(MatchDTO matchDTO) {
        return MatchEntity.builder()
                .matchId(matchDTO.getId())
                .gameCount(matchDTO.getStrategy() != null ? matchDTO.getStrategy().getCount() : null)
                .teams(matchDTO.getTeams() != null ? mapTeams(matchDTO.getTeams()) : null)
                .build();
    }
}
