package com.example;

import com.example.not_web.dao.Dao;
import com.example.not_web.dao.UserDaoForTests;
import com.example.not_web.models.User;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void testGetUsers() {
        Dao dao = new UserDaoForTests();
        User user1 = new User(0L, "max", 18, "Male");
        User user2 = new User(1L, "ann", 20, "Female");
        List<User> exp = List.of(
                user1,
                user2
                );
        dao.save(user1);
        dao.save(user2);
       assertArrayEquals(exp.toArray(), dao.getUsers().toArray());
    }

    @Test
    public void testFindUserById() {
        Dao dao = new UserDaoForTests();
        User user1 = new User(0L, "max", 18, "Male");
        dao.save(user1);
        assertEquals(user1, dao.findUserById(0));
    }

    @Test
    public void testSave() {
        Dao dao = new UserDaoForTests();
        User user1 = new User(0L, "max", 18, "Male");
        dao.save(user1);
        assertTrue(dao.getUsers().contains(user1));
    }

    @Test
    public void testEditUser() {
        Dao dao = new UserDaoForTests();
        User user1 = new User(0L, "max", 18, "Male");
        dao.save(user1);
        assertTrue(dao.editUser("Johnny", 0));
        assertEquals("Johnny", dao.findUserById(0).getNickname());
    }

    @Test
    public void testDeleteUser() {
        Dao dao = new UserDaoForTests();
        User user1 = new User(0L, "max", 18, "Male");
        dao.save(user1);
        assertTrue(dao.getUsers().contains(user1));
        assertTrue(dao.deleteUser(0));
        assertNull(dao.findUserById(0));
    }
}
