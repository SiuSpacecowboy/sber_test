package com.example.not_web_app.models;

import lombok.*;

/** Модель данных для CRUD приложения регистрации на сайте знакомств. */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String nickname;
    /** Значение данной переменной должно быть не меньше 18, дальше проверяется в коде. */
    private int age;
    private String gender;

}
