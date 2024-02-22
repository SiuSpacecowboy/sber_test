package com.example.user_actions;

import com.example.dao.Dao;
import com.example.input.Input;
import com.example.models.User;


/** Класс, отвечающий за действие создания нового пользователя. */
public class CreateAction implements UserAction {

    /** Переменная для присвоения пользователю уникального ID. */
    private static int ID;

    @Override
    public String name() {
        return "Create new User";
    }

    /** Данный метод отвечает за регистрацию нового пользователя.
     * Если регистрирующийся вводит возраст меньше 18, такое значение не примется и клиент вернется на главный экран,
     * не сумев при этом зарегистрироваться. */
    @Override
    public boolean execute(Input input, Dao dao) throws InterruptedException {
        System.out.println("=== New User creation ====");
        User user = new User();
        int age = input.askInt("Enter age: ");
        if (age < 18) {
            System.out.println("Не пройдено возрастное ограничение, отказано в регистрации.");
        } else {
            String nickname = input.askStr("Enter nickname: ");
            String gender = input.askTwoSymb("F", "M",
                    "Select your gender, F if female, M if male: ");
            user.setNickname(nickname);
            user.setId(++ID);
            user.setAge(age);
            if (gender.equalsIgnoreCase("f")) {
                user.setGender("Female");
            } else {
                user.setGender("Male");
            }
            dao.save(user);
            System.out.println("Пользователь успешно зарегистрирован.");
        }
        Thread.sleep(600);
        return true;
    }
}

