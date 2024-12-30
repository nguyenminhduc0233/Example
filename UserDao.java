package com.example.dao;

import com.example.model.User;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class UserDao {

    // Thêm người dùng bằng native SQL
    public void saveUser(String username, String email) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String sql = "INSERT INTO users (username, email) VALUES (:username, :email)";
            NativeQuery<?> query = session.createNativeQuery(sql);
            query.setParameter("username", username);
            query.setParameter("email", email);

            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Lấy thông tin người dùng bằng native SQL
    public User getUserById(Long id) {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT * FROM users WHERE id = :id";
            NativeQuery<User> query = session.createNativeQuery(sql, User.class);
            query.setParameter("id", id);
            user = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
