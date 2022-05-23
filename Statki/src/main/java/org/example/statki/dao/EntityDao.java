package org.example.statki.dao;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class EntityDao<T> {
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    public List<T> getById(int id) {
        Session session = sessionFactory.openSession();
        List<T> resultList = session.createQuery("From :parameter a Where a.id = :parameterId", clazz)
                .setParameter("parameter", clazz)
                .setParameter("parameterId", id)
                .getResultList();
        session.close();
        return resultList;
    }

    public int save(T input){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int save = (int) session.save(input);
        transaction.commit();
        session.close();
        return save;
    }

    public List<T> getAllArguments(){
        Session session = sessionFactory.openSession();
        List<T> resultList = session.createQuery("From :parameter", clazz)
                .setParameter("parameter", clazz)
                .getResultList();
        session.close();
        return resultList;
    }


}
