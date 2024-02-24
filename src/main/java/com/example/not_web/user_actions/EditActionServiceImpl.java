package com.example.not_web.user_actions;

import com.example.not_web.dao.Dao;
import com.example.not_web.input.Input;

/** Класс, отвечающий за действие изменения никнейма пользователя. */
public class EditActionServiceImpl implements UserActionService {

    @Override
    public String name() {
        return "Edit User";
    }

    @Override
    public boolean execute(Input input, Dao dao) throws InterruptedException {
        System.out.println("=== Edit User ===");
        int id = input.askInt("Enter id: ");
        String nickname = input.askStr("Enter new nickname: ");
        if (dao.editUser(nickname, id)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        Thread.sleep(600);
        return true;
    }
}
