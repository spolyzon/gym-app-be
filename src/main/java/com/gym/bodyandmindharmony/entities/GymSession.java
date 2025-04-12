package com.gym.bodyandmindharmony.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(
        exclude = {"client"}
)
@Entity
@Table(name = "GYM_SESSION")
public class GymSession {

    @Id
    @Column(name = "GYM_SESSION_ID")
    private String id;

    @Column(name = "SESSION_TYPE")
    private String type;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "FINISH_TIME")
    private LocalDateTime finishTime;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToMany(
            mappedBy = "gymSession",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Exercise> exerciseList;
}
