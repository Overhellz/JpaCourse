package com.github.rodiond26.persistence_context.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "subject")
    String subject;

    @Column(name = "is_professor")
    boolean isProfessor;

    public Teacher(String name, String surname, String subject, boolean isProfessor) {
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.isProfessor = isProfessor;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", isProfessor=" + isProfessor +
                '}';
    }
}
