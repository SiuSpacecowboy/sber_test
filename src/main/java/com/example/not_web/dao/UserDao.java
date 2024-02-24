package com.example.not_web.dao;

import com.example.not_web.models.User;

import java.util.ArrayList;
import java.util.List;

/** Класс, который реализует интерфейс Dao, для работы с приложением. */
public class UserDao implements Dao {

    private static UserDao dao;

    /** Условное хранилище данных. */
    private static final List<User> users = new ArrayList<>();

    private UserDao(){}

    /** Реализован шаблон Singleton для создания только одного экземпляра класса.
     * Использована реализация ленивой загрузки.
     * @return Объект типа UserDao. */
    public static UserDao getUserDao() {
        if (dao == null) {
            dao = new UserDao();
        }
        return dao;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User findUserById(int id) {
        return users.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public boolean editUser(String nickname, int id) {
        User startUser = findUserById(id);
        if (startUser != null) {
            startUser.setNickname(nickname);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        return users.remove(findUserById(id));
    }
}
