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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Exercise {

    @Id
    private String exerciseId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REPETITIONS")
    private int repetitions;

    @Column(name = "WEIGHT")
    private double weight;

    @ManyToOne
    @JoinColumn(name = "GYM_SESSION_ID")
    private GymSession gymSession;
}
