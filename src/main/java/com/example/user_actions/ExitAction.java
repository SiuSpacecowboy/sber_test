package com.example.user_actions;

import com.example.dao.Dao;
import com.example.input.Input;

/** Класс, отвечающий за выход из приложеня - прекращение работы программы. */
public class ExitAction implements UserAction {

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Dao tracker) {
        System.out.println("=== Exit Program ===");
        return false;
    }
}

