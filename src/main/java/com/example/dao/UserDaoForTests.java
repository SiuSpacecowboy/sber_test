package com.example.dao;

import com.example.models.User;
import java.util.ArrayList;
import java.util.List;

/** Класс, который реализует интерфейс Dao, для написания тестов. */
public class UserDaoForTests implements Dao {

    /** Условное хранилище данных. */
    private final List<User> users = new ArrayList<>();

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
