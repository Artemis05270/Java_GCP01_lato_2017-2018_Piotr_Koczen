package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.repository;


import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.domain.User;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto.UserCreation;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private final SessionFactory sessionFactory;

    public UserRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void create(Map<String, String> credentials) {
        if (credentials == null) {
            throw new IllegalArgumentException("The user cannot be null.");
        }

        String username = credentials.get("username");
        String password = credentials.get("password");
        String email = credentials.get("email");

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        User createdUser = new User();
        createdUser.setUsername(username);
        createdUser.setPassword(password);
        createdUser.setEmail(email);
        createdUser.setCreatedAt(LocalDateTime.now().minusNanos(0));
        session.save(createdUser);

        transaction.commit();
        session.close();
    }

    public Optional<User> login(String username, String password) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User user where user.username = :username");
        query.setParameter("username", username);

        List<User> users = query.getResultList();

        session.close();

        return users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findAny();
    }

    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User user");

        return query.getResultList();
    }

    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }
}
