package com.example.ui;

import com.example.dao.Dao;
import com.example.input.Input;
import com.example.user_actions.UserActionService;
import java.util.List;
import java.util.stream.IntStream;

/** Класс, имитирующий пользовательский интерфейс. */
public class StartUi {

    /** Метод, инициализирующий и отвечающий за дальнейшее бесперебойное протекание программы.
     * Прекращает свою работу при вызове метода execute класса ExitAction.
     * @param input Объект ввода для взаимодействия с пользователем.
     * @param dao Объект Dao для доступа к данным.
     * @param actions Список возможных действий, с которыми может работать пользователь.
     * */
    public void init(Input input, Dao dao, List<UserActionService> actions) throws InterruptedException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 1 || select > actions.size()) {
                System.out.println("Wrong input, you can select: 1 .. " + (actions.size()));
                Thread.sleep(500);
                continue;
            }
            UserActionService action = actions.get(select - 1);
            run = action.execute(input, dao);
        }
    }

    /** Метод для отображения возможностей пользователя. */
    private void showMenu(List<UserActionService> actions) {
        System.out.println("Menu:");
        IntStream.rangeClosed(0, actions.size() - 1)
                .forEach(v ->  System.out.println(v + 1 + ". " + actions.get(v).name()));
    }
}
