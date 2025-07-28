package com.auth.Repository;

import com.auth.Entity.UserRegisterEntity;
import com.auth.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRegisterEntityRepository {

    public UserRegisterEntity saveUser(UserRegisterEntity user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            return user;
        }
    }

    public Optional<UserRegisterEntity> findByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(UserRegisterEntity.class, username));
        }
    }

    public void deleteUser(UserRegisterEntity user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(user);
            tx.commit();
        }
    }

    public void updateUser(UserRegisterEntity user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        }
    }

    public List<UserRegisterEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM UserRegisterEntity", UserRegisterEntity.class).list();
        }
    }
}
