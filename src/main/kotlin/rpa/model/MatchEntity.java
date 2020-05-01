package rpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatchEntity {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String matchId;

    @Column
    private Integer gameCount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TeamEntity> teams;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId()
    private EventEntity event;
}
