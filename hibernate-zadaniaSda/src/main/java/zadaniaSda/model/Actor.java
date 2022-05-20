package zadaniaSda.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private Integer yearOfBirth;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Movie> movies;

    public Actor(String name, Integer yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String toString() {
        return "Actor(id=" + this.getId() + ", name=" + this.getName() + ", lastName=" + this.getLastName() + ", yearOfBirth=" + this.getYearOfBirth();
    }
}
