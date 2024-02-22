package com.example;

import com.example.dao.Dao;
import com.example.dao.UserDao;
import com.example.input.Input;
import com.example.user_actions.*;
import java.util.List;

/** Запуск программы. */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Dao dao = UserDao.getUserDao();
        Input input = new Input();
        List<UserAction> actions = List.of(
                new CreateAction(),
                new ShowAllUsersAction(),
                new FindByIdAction(),
                new EditAction(),
                new DeleteAction(),
                new ExitAction()
        );
        new StartUi().init(input, dao, actions);
    }
}
