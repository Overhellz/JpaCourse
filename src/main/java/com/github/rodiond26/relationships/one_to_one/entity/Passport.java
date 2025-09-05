package com.github.rodiond26.relationships.one_to_one.entity;

import com.github.rodiond26.relationships.one_to_one.enumz.EyeColor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "passports")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "email")
    String email;

    @Column(name = "height")
    int height;

    @Enumerated(EnumType.STRING)
    @Column(name = "eye_color")
    EyeColor eyeColor;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL) // прописано в классе Student в поле passport
    Student student;

    public Passport(String email, int height, EyeColor eyeColor) {
        this.email = email;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
