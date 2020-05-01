package rpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LeagueEntity {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String region;

    @Column
    private Integer priority;
}
