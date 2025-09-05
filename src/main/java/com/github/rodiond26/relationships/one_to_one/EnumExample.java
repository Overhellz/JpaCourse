package com.github.rodiond26.relationships.one_to_one;

import com.github.rodiond26.relationships.one_to_one.entity.Passport;
import com.github.rodiond26.relationships.one_to_one.entity.Student;
import com.github.rodiond26.relationships.one_to_one.enumz.EyeColor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EnumExample {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Student student = new Student("name1", "surname1", 7.1);
//            Passport passport = new Passport("email1", 171, EyeColor.GREEN);
//            student.setPassport(passport);
//            passport.setStudent(student);
//            entityManager.persist(student);

            Student student = entityManager.find(Student.class, 1);
            System.out.println(student.getPassport());

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
