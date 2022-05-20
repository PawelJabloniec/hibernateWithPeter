package zadaniaSda.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Integer yearOfRelease;
    @OneToOne
    private Genre genre;
    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER)
    private Set<Actor> actors;

    public Movie(String title, Integer yearOfRelease) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
    }
}
