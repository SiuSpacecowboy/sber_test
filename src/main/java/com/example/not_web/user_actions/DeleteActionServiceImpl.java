package com.example.not_web.user_actions;

import com.example.not_web.dao.Dao;
import com.example.not_web.input.Input;

/** Класс, отвечающий за действие удаления пользователя. */
public class DeleteActionServiceImpl implements UserActionService {

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

