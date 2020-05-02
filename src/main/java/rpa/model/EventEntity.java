package rpa.model;

import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class EventEntity {

    public EventEntity(EventEntity eventEntity) {
        this(eventEntity.eventId, eventEntity.getStartTime(), eventEntity.getType(), eventEntity.getMatch(), eventEntity.getLeagueName());
    }

    @Id
    @Column
    @GeneratedValue
    private Long eventId;

    @Column
    private LocalDateTime startTime;

    @Column
    private String type;

    //match
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private MatchEntity match;

    @Column
    private String leagueName;
}

