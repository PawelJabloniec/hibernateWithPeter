package org.example;

import org.example.statki.HibernateFactory;
import org.example.statki.model.User;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        SessionFactory sessionFactory = new HibernateFactory().getSessionFactory();
        User pawel = new User("pawel", 0, 0);
        User piotrek = new User("piotrek", 0, 0);







    }

}
