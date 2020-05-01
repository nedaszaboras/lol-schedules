package rpa.model;

import lombok.Data;

@Data
public class TeamDTO {
    private String code;
    private String name;
    private String image;
    private ResultDTO result;
    private RecordDTO record;
}
