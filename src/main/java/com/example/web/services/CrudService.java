package com.example.web.services;

import com.example.web.dto.User;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Интерфейс, представляющий CRUD (Create, Read, Update, Delete) операции для сущности User.
 */
public interface CrudService {

    /**
     * Метод для поиска всех пользователей.
     *
     * @return Список всех пользователей
     */
    public List<User> findAllUsers();

    /**
     * Метод для поиска пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя
     * @return Найденный пользователь
     * @throws NoSuchElementException если пользователь с указанным идентификатором не найден
     */
    public User findUserById(long id) throws NoSuchElementException;

    /**
     * Метод для сохранения нового пользователя.
     *
     * @param newUser Новый пользователь для сохранения
     */
    public void saveUser(User newUser);

    /**
     * Метод для редактирования существующего пользователя.
     *
     * @param nickname Новый никнейм пользователя
     * @param name Новое имя пользователя
     * @param id Идентификатор пользователя, которого нужно отредактировать
     */
    public void editUser(String nickname, String name, long id);

    /**
     * Метод для удаления пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя, которого нужно удалить
     */
    public void deleteUser(Long id);
}
