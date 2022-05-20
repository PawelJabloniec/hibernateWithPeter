package zadaniaSda.Dao;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Optional;

@AllArgsConstructor
public abstract class EntityDao<T> {
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    public Optional<T> getById(int id) {
        Session session = sessionFactory.openSession();
        T object = session.find(clazz, id);
        session.close();
        return Optional.ofNullable(object);
    }

    public int save(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int save = (int) session.save(entity);

        transaction.commit();
        session.close();
        return save;
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        getById(id).ifPresent(entity -> session.delete(entity));
        transaction.commit();
        session.close();
    }


}
