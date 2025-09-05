package com.github.rodiond26.crud.jpa_crud;

import com.github.rodiond26.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindExample {
    public static void main(String[] args) {

        // <persistence-unit name="jpa-course">
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        Student student1 = null;

        try {
            student1 = entityManager.find(Student.class, 3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }

        System.out.println(student1);
    }
}
