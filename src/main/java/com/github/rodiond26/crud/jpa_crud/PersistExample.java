package com.github.rodiond26.crud.jpa_crud;

import com.github.rodiond26.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistExample {
    public static void main(String[] args) {

        // <persistence-unit name="jpa-course">
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Student student1 = null;
        Student student2 = null;
        Student student3 = null;
        Student student4 = null;

        try {
            transaction.begin();
            student1 = new Student("Chanel", "King", 9.1);
            student2 = new Student("Leo", "Farrell", 8.4);
            student3 = new Student("Yulia", "Dean", 8.7);
            student4 = new Student("Yulia", "Dean", 8.7);
            entityManager.persist(student1);
            entityManager.persist(student2);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }

        System.out.println(student1);
        System.out.println(student3);
        System.out.println(student2);
    }
}
