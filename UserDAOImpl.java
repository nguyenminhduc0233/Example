package com.example.dao;

import com.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public User findUserByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.createQuery("FROM User WHERE username = :username AND password = :password")
                             .setParameter("username", username)
                             .setParameter("password", password)
                             .uniqueResult();
    }
}
