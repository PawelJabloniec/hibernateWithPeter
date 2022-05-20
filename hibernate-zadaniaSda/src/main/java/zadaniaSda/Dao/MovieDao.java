package zadaniaSda.Dao;

import org.hibernate.SessionFactory;
import zadaniaSda.model.Movie;

public class MovieDao extends EntityDao<Movie>{
    public MovieDao(SessionFactory sessionFactory) {
        super(sessionFactory, Movie.class);
    }
}
