package com.github.rodiond26.relationships.one_to_one;

import com.github.rodiond26.relationships.one_to_one.entity.Passport;
import com.github.rodiond26.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneBi {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // PERSIST
//            Student student1 = new Student("Mark", "Smith", 9.1);
//            Passport passport1 = new Passport("mark.smith@gmail.com", 178, "blue");
//            passport1.setStudent(student1);
//            student1.setPassport(passport1);
//            entityManager.persist(passport1);

            // FIND
//            Passport passport1 = entityManager.find(Passport.class, 2);
//            System.out.println(passport1);
//            System.out.println(passport1.getStudent());

            // REMOVE
            Passport passport1 = entityManager.find(Passport.class, 2);
            passport1.getStudent().setPassport(null);
            entityManager.remove(passport1);

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
