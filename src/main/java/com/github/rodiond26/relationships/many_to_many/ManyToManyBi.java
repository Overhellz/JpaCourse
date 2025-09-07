package com.github.rodiond26.relationships.many_to_many;

import com.github.rodiond26.relationships.many_to_many.entity.Teacher;
import com.github.rodiond26.relationships.many_to_many.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ManyToManyBi {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            // PERSIST
//            University university1 = new University("Harvard", Date.valueOf("1636-10-28"));
//            University university2 = new University("Oxford", Date.valueOf("1200-09-01"));
//            University university3 = new University("MIT", Date.valueOf("1861-04-10"));
//
//            Teacher teacher1 = new Teacher("name1", "surname1", "subject1", true);
//            Teacher teacher2 = new Teacher("name2", "surname2", "subject2", false);
//            Teacher teacher3 = new Teacher("name3", "surname3", "subject3", true);
//
//            university1.addTeacherToUniversity(teacher1);
//            university1.addTeacherToUniversity(teacher2);
//            university1.addTeacherToUniversity(teacher3);
//
//            entityManager.persist(university1);
//            entityManager.persist(university2);
//            entityManager.persist(university3);

//            Teacher teacher4 = new Teacher("name4", "surname4", "subject4", false);
//            University university4 = new University("Harvard", Date.valueOf("1636-10-28"));
//            University university5 = new University("Oxford", Date.valueOf("1200-09-01"));
//            University university6 = new University("MIT", Date.valueOf("1861-04-10"));
//            teacher4.addUniversityToTeacher(university4);
//            teacher4.addUniversityToTeacher(university5);
//            teacher4.addUniversityToTeacher(university6);
//
//            entityManager.persist(teacher4);

            // FIND
//            University university = entityManager.find(University.class, 1);
//            System.out.println(university.getTeachers());

//            Teacher teacher = entityManager.find(Teacher.class , 4);
//            System.out.println(teacher.getUniversities());

            // REMOVE
//            Teacher teacher = entityManager.find(Teacher.class, 1);
//            University university = entityManager.find(University.class, 2);
//            teacher.addUniversityToTeacher(university);
//            entityManager.persist(teacher);

//            Teacher teacher = entityManager.find(Teacher.class, 1);
//            entityManager.remove(teacher);

//            Teacher teacher = entityManager.find(Teacher.class, 8);
//            University university = entityManager.find(University.class, 9);
//            teacher.addUniversityToTeacher(university);
//            entityManager.persist(teacher);

//            Teacher teacher = entityManager.find(Teacher.class, 8);
//            entityManager.remove(teacher);

            University university = entityManager.find(University.class, 11);
            entityManager.remove(university);

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
