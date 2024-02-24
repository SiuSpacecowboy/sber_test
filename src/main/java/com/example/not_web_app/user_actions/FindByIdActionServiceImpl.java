package com.example.not_web_app.user_actions;

import com.example.not_web_app.dao.Dao;
import com.example.not_web_app.input.Input;
import com.example.not_web_app.models.User;

/** Класс, отвечающий за действие поиска пользователя по его ID. */
public class FindByIdActionServiceImpl implements UserActionService {

    @Override
    public String name() {
        return "Find user by id";
    }

    @Override
    public boolean execute(Input input, Dao dao) throws InterruptedException {
        System.out.println("=== Find user by id ===");
        int id = input.askInt("Enter id: ");
        User user = dao.findUserById(id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        Thread.sleep(600);
        return true;
    }
}


