package rpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamsResponseDTO  {
    private String code;
    private String name;
    private String image;
    private Integer recordWins;
    private Integer recordLosses;
}
