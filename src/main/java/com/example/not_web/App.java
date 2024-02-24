package com.example.not_web;

import com.example.not_web.dao.Dao;
import com.example.not_web.dao.UserDao;
import com.example.not_web.input.Input;
import com.example.not_web.ui.StartUi;
import com.example.not_web.user_actions.*;

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
