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
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
public class Client {

    @Id
    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "client"
    )
    private List<GymSession> gymSessions;

}
