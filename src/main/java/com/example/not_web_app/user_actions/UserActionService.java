package com.example.not_web_app.user_actions;

import com.example.not_web_app.dao.Dao;
import com.example.not_web_app.input.Input;

/**
 Интерфейс для создания объектов действий пользователя.
 */
public interface UserActionService {

    /**
     * Получение имя действия пользователя.
     *
     * @return Имя действия пользователя.
     */
    String name();

    /**
     * Выполнение действия пользователя с заданным объектом ввода и объектом доступа к данным.
     * Особенность каждого из реализовывающих этот интерфейс классов - засыпание на 600ms для более плавного и приятного перехода.
     * @param input Объект ввода для взаимодействия с пользователем.
     * @param dao   Объект Dao для доступа к данным.
     * @return Всегда true, если действие не связано с классом, отвечающим за выход из приложения.
     * @throws InterruptedException если действие прерывается во время выполнения.
     */
    boolean execute(Input input, Dao dao) throws InterruptedException;
}
