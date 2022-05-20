package zadaniaSda.Dao;

import org.hibernate.SessionFactory;
import zadaniaSda.model.Actor;

public class ActorDao extends EntityDao{
    public ActorDao(SessionFactory sessionFactory) {
        super(sessionFactory, Actor.class);
    }
}
