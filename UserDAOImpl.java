package com.example.dao;

import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }
}
