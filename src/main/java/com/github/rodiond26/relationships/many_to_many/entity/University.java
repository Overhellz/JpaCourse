package com.github.rodiond26.relationships.many_to_many.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "universities")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "founding_date")
    Date foundingDate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "teacher_university",
            joinColumns = @JoinColumn(name = "university_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    List<Teacher> teachers = new ArrayList<>();

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public void addTeacherToUniversity(Teacher teacher) {
        this.teachers.add(teacher);
    }

    @Override
    public String toString() {
        return "University{" +
                "foundingDate=" + foundingDate +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
