package zadaniaSda.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @OneToOne(mappedBy = "genre", fetch = FetchType.EAGER)
    private Movie movie;

    public Genre(String name) {
        this.name = name;
    }

    public String toString() {
        return "Genre(id=" + this.getId() + ", name=" + this.getName();
    }
}
