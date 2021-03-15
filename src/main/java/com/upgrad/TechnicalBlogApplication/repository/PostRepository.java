package com.upgrad.TechnicalBlogApplication.repository;

import com.upgrad.TechnicalBlogApplication.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public List<Post> getAllPosts(Integer userId) {
        // WORKING ON JPA
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p JOIN FETCH p.user puser WHERE puser.id = :userId", Post.class);
        query.setParameter("userId", userId);
        List<Post> result = query.getResultList();
        return result;
    }

    public void createPost(Post newPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public Post getPost(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Post.class, postId);
    }

    public void updatePost(Post updatedPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(updatedPost);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}
