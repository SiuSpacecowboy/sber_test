package com.example.user_actions;

import com.example.dao.Dao;
import com.example.input.Input;

/** Класс, отвечающий за действие вывода всех пользователей в консоль. */
public class ShowAllUsersActionServiceImpl implements UserActionService {

    @Override
    public String name() {
        return "Show All Users";
    }

    @Override
    public boolean execute(Input input, Dao dao) throws InterruptedException {
        System.out.println("=== Find All Users ===");
        if (dao.getUsers().isEmpty()) {
            System.out.println("Нет ни одного зарегистрированного пользователя.");
        } else {
            dao.getUsers().forEach(System.out::println);
        }
        Thread.sleep(600);
        return true;
    }
}
