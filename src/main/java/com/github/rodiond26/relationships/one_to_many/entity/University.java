package com.github.rodiond26.relationships.one_to_many.entity;

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

    @OneToMany(mappedBy = "university", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("avgGrade DESC, name ASC")
    List<Student> students = new ArrayList<>();

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public void addStudentToUniversity(Student student) {
        students.add(student);
        student.setUniversity(this);
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
