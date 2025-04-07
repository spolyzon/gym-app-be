package com.gym.bodyandmindharmony.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "GYM_SESSION")
public class GymSession {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "FINISH_TIME")
    private LocalDateTime finishTime;

    @Column(name = "CLIENT")
    private String client;
}
