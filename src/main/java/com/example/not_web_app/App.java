package com.example.not_web_app;

import com.example.not_web_app.dao.Dao;
import com.example.not_web_app.dao.UserDao;
import com.example.not_web_app.input.Input;
import com.example.not_web_app.ui.StartUi;
import com.example.not_web_app.user_actions.*;

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
