package com.example.web.repo;

import com.example.web.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Интерфейс репозитория для работы с сущностью User.
 * Этот интерфейс расширяет JpaRepository для сущности User с идентификатором типа Long.
 * Для данного проекта использовал базу данных H2.
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    /**
     * Метод для обновления данных пользователя по идентификатору.
     *
     * @param nickname Новый никнейм пользователя
     * @param name Новое имя пользователя
     * @param id Идентификатор пользователя, данные которого нужно обновить
     */
    @Transactional
    @Modifying
    @Query("update User u set u.nickname = ?1, u.name = ?2 where u.id = ?3")
    void updateUser(String nickname, String name, long id);
}
