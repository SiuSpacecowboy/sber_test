package com.example.user_actions;

import com.example.dao.Dao;
import com.example.input.Input;

/** Класс, отвечающий за действие удаления пользователя. */
public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "Delete User";
    }

    /** Данный метод удаляет пользователя по его ID. */
    @Override
    public boolean execute(Input input, Dao dao) throws InterruptedException {
        System.out.println("=== Delete User ===");
        int id = input.askInt("Enter id: ");
        if (dao.deleteUser(id)) {
            System.out.println("Заявка успешно удалена.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        Thread.sleep(600);
        return true;
    }
}

