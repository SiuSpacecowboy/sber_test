package com.example.web_app.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** Класс, представляющий сущность пользователя с различными аннотациями для работы с JPA.*/
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    /**
     * Уникальный идентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "humans_id")
    @SequenceGenerator(
            name = "humans_id",
            sequenceName = "humans_id",
            allocationSize = 1
    )
    private long id;

    /**
     * Никнейм пользователя.
     */
    @NotBlank(message = "Поле не должно быть пустым.")
    private String nickname;


    @Min(value = 18L, message = "Пользователь должен быть совершеннолетним.")
    private int age;

    @NotBlank(message = "Поле не должно быть пустым.")
    private String name;

    @Column(nullable = false)
    private String gender;

    public User(String nickname, String name, int age, String gender) {
        this.nickname = nickname;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
