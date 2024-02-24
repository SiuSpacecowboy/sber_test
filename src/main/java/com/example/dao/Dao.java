package com.example.dao;

import com.example.models.User;
import java.util.List;

/**
 * Data Access Object.
 * Интерфейс для объекта доступа к данным.
 */
public interface Dao {

    /**
     * Возвращает всех имеющихся пользователей.
     *
     * @return Список объектов типа User. */
    public List<User> getUsers();

    /**
     * Ищет пользователя по его ID.
     *
     * @param id ID пользователя, которого надо найти.
     * @return Объект User, имеющий указанный ID */
    public User findUserById(int id);

    /**
     * Сохраняет нового пользователя.
     *
     * @param user Объект User для сохранения. */
    public void save(User user);

    /**
     * Редактирует никнейм пользователя по его ID.
     *
     * @param nickname Новый никнейм.
     * @param id ID пользователя для изменения.
     * @return True, если пользователь был успешно отредактирован, false в противном случае. */
    public boolean editUser(String nickname, int id);

    /**
     * Удаляет пользователя по его ID.
     * @param id ID пользователя для удаления.
     * @return True если пользователь был успешно удален, в противном случае — false */
    public boolean deleteUser(int id); }

