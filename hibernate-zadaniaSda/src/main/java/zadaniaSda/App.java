package zadaniaSda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import zadaniaSda.Dao.ActorDao;
import zadaniaSda.Dao.GenreDao;
import zadaniaSda.Dao.MovieDao;
import zadaniaSda.model.Actor;
import zadaniaSda.model.Genre;
import zadaniaSda.model.Movie;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        ActorDao actorDao = new ActorDao(sessionFactory);
        MovieDao movieDao = new MovieDao(sessionFactory);
        GenreDao genreDao = new GenreDao(sessionFactory);

        createTables(actorDao, movieDao, genreDao);
        System.out.println(movieDao.getById(2));


        sessionFactory.close();
    }

    private static void createTables(ActorDao actorDao, MovieDao movieDao, GenreDao genreDao) {
        Genre genre = new Genre("Horror");
        Genre animated = new Genre("Animated");
        Genre comedy = new Genre("Comedy");
        Actor actor = new Actor("Pawel", 1990);
        Actor piotrek = new Actor("Piotrek", 1990);
        Movie movie = new Movie("Dracula", 2004);
        Movie muminki = new Movie("Muminki", 1997);
        Movie terminator = new Movie("Terminator", 1999);

        muminki.setGenre(animated);
        terminator.setGenre(genre);
        movie.setGenre(comedy);
        movie.setActors(Set.of(actor));
        muminki.setActors(Set.of(piotrek, actor));
        terminator.setActors(Set.of(piotrek, actor));
        piotrek.setMovies(Set.of(muminki, terminator));
        actor.setMovies(Set.of(movie, muminki, terminator));

        genreDao.save(genre);
        genreDao.save(animated);
        genreDao.save(comedy);
        movieDao.save(muminki);
        movieDao.save(terminator);
        movieDao.save(movie);
        actorDao.save(piotrek);
        actorDao.save(actor);
    }
}
