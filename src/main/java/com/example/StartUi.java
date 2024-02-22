package com.example;

import com.example.dao.Dao;
import com.example.input.Input;
import com.example.user_actions.UserAction;
import java.util.List;

/** Класс, имитирующий пользовательский интерфейс. */
public class StartUi {

    /** Метод, инициализирующий и отвечающий за дальнейшее бесперебойное протекание программы.
     * Прекращает свою работу при вызове метода execute класса ExitAction.
     * @param input Объект ввода для взаимодействия с пользователем.
     * @param dao Объект Dao для доступа к данным.
     * @param actions Список возможных действий, с которыми может работать пользователь.
     * */
    public void init(Input input, Dao dao, List<UserAction> actions) throws InterruptedException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 1 || select > actions.size()) {
                System.out.println("Wrong input, you can select: 1 .. " + (actions.size()));
                Thread.sleep(500);
                continue;
            }
            UserAction action = actions.get(select - 1);
            run = action.execute(input, dao);
        }
    }

    /** Метод для отображения возможностей пользователя. */
    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + 1 + ". " + actions.get(index).name());
        }
    }
}
