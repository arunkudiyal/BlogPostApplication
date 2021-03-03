package com.upgrad.TechnicalBlogApplication.repository;

import com.upgrad.TechnicalBlogApplication.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class UserRepository {

    // EntityManagerFactory
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public void registerUser(User newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
