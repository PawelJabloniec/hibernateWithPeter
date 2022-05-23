package org.example.statki.dao;

import org.example.statki.HibernateFactory;
import org.example.statki.model.User;
import org.hibernate.SessionFactory;

public class UserDao extends EntityDao<User>{
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }
}
