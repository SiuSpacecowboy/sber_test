package com.example.web_app.services;

import com.example.web_app.dto.User;
import com.example.web_app.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

/** Класс, реализующий интерфейс CrudService */
@Service
public class UserCrudServiceImpl implements CrudService {

    private final UsersRepository repository;

    @Autowired
    public UserCrudServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User findUserById(long id) throws NoSuchElementException {
        return repository.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    public void editUser(String nickname, String name, long id) {
        repository.updateUser(nickname, name, id);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
