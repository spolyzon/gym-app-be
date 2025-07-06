package com.gym.bodyandmindharmony.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
