package org.example.statki.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlayBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    private User user1;
    private User user2;
    private int[][] playBoardCoordination;

    public PlayBoard(User user1, User user2, int[][] playBoardCoordination) {
        this.user1 = user1;
        this.user2 = user2;
        this.playBoardCoordination = playBoardCoordination;
    }
}
