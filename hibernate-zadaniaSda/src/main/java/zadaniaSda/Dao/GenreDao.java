package zadaniaSda.Dao;

import org.hibernate.SessionFactory;
import zadaniaSda.model.Genre;

public class GenreDao extends EntityDao<Genre>{
    public GenreDao(SessionFactory sessionFactory) {
        super(sessionFactory, Genre.class);
    }
}
