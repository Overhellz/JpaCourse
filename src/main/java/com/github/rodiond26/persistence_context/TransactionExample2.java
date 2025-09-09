package com.github.rodiond26.persistence_context;

import com.github.rodiond26.persistence_context.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TransactionExample2 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Teacher teacher1 = new Teacher("name8", "surname8", "subject8", true);
            Teacher teacher2 = new Teacher("name9", "surname9", "subject9", false);

            entityManager.persist(teacher1);

            Teacher findTeacher = entityManager.find(Teacher.class, 100);
            findTeacher.getName();
            findTeacher.getSurname();

            entityManager.persist(teacher2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("======= Rollback! =======");
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
