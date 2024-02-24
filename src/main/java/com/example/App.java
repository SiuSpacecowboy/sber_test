package com.example;

import com.example.dao.Dao;
import com.example.dao.UserDao;
import com.example.input.Input;
import com.example.ui.StartUi;
import com.example.user_actions.*;
import java.util.List;

/** Запуск программы. */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Dao dao = UserDao.getUserDao();
        Input input = new Input();
        List<UserActionService> actions = List.of(
                new CreateActionServiceImpl(),
                new ShowAllUsersActionServiceImpl(),
                new FindByIdActionServiceImpl(),
                new EditActionServiceImpl(),
                new DeleteActionServiceImpl(),
                new ExitActionServiceImpl()
        );
        new StartUi().init(input, dao, actions);
    }
}
