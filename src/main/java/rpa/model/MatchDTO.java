package rpa.model;

import lombok.Data;

import java.util.List;

@Data
public class MatchDTO {
    private List<TeamDTO> teams;
    private String id;
    private StrategyDTO strategy;
}
