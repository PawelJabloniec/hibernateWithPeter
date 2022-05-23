package org.example.statki.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private int partialScore;
    private int totalScore;
    @ManyToMany
    private List<Integer> boardsList;

    public User(String userName, int partialScore, int totalScore) {
        this.userName = userName;
        this.partialScore = partialScore;
        this.totalScore = totalScore;
    }
}
