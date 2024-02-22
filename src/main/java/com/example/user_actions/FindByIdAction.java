package com.example.user_actions;

import com.example.dao.Dao;
import com.example.input.Input;
import com.example.models.User;

/** Класс, отвечающий за действие поиска пользователя по его ID. */
public class FindByIdAction implements UserAction {

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


