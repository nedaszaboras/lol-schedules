package rpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamEntity {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String image;

    @Column
    private Integer recordWins;

    @Column
    private Integer recordLosses;

}
