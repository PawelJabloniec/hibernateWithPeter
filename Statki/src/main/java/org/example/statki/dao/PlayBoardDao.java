package org.example.statki.dao;

import org.example.statki.model.PlayBoard;
import org.hibernate.SessionFactory;

public class PlayBoardDao extends EntityDao<PlayBoard> {
    public PlayBoardDao(SessionFactory sessionFactory) {
        super(sessionFactory, PlayBoard.class);
    }
}
