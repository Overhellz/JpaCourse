package com.github.rodiond26.relationships.one_to_one;

import com.github.rodiond26.relationships.one_to_one.entity.Passport;
import com.github.rodiond26.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneUni {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // PERSIST
//            Student student2 = new Student("Mark", "Smith", 9.1);
//            Passport passport2 = new Passport("mark.smith@gmail.com", 178, "blue");
//            student2.setPassport(passport2);
//
//            entityManager.persist(passport2);
//            entityManager.persist(student2);

            // FIND
//            Student student = entityManager.find(Student.class, 2);
//            System.out.println(student);
//            System.out.println(student.getPassport());

            // REMOVE
//            Student student = entityManager.find(Student.class, 2);
//            entityManager.remove(student);

            //UPDATE
//            Student student = entityManager.find(Student.class, 3);
//            student.setAvgGrade(7.7);
//            Passport passport = student.getPassport();
//            passport.setEyeColor("white");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
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
