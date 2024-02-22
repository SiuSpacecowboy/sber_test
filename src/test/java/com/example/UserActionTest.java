package com.example;

import com.example.dao.Dao;
import com.example.dao.UserDao;
import com.example.dao.UserDaoForTests;
import com.example.input.Input;
import com.example.models.User;
import com.example.user_actions.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UserActionTest {

    @Test
    public void CreateActionSuccessTest() throws InterruptedException {
        Dao dao = mock(UserDao.class);
        Input input = mock(Input.class);
        UserAction action = new CreateAction();
        when(input.askInt("Enter age: ")).thenReturn(20);
        when(input.askStr("Enter nickname: ")).thenReturn("Max");
        when(input.askStr("Select your gender, F if female, M if male: ")).thenReturn("M");
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(dao, times(1)).save(any(User.class));
    }

    @Test
    public void CreateActionAgeBellow18Test() throws InterruptedException {
        Dao dao = mock(UserDao.class);
        Input input = mock(Input.class);
        UserAction action = new CreateAction();
        when(input.askInt("Enter age: ")).thenReturn(16);
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(dao, never()).save(any(User.class));
    }

    @Test
    public void DeleteActionTest() throws InterruptedException {
        Dao dao = mock(UserDaoForTests.class);
        Input input = mock(Input.class);
        UserAction action = new DeleteAction();
        when(input.askInt("Enter id: ")).thenReturn(1);
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(input, times(1)).askInt("Enter id: ");
        verify(dao, times(1)).deleteUser(1);
    }

    @Test
    public void EditActionTest() throws InterruptedException {
        Dao dao = mock(UserDaoForTests.class);
        Input input = mock(Input.class);
        UserAction action = new EditAction();
        when(input.askInt("Enter id: ")).thenReturn(1);
        when(input.askStr("Enter new nickname: ")).thenReturn("John");
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(input, times(1)).askInt("Enter id: ");
        verify(input, times(1)).askStr("Enter new nickname: ");
        verify(dao, times(1)).editUser("John", 1);
    }

    @Test
    public void FindByIdActionTest() throws InterruptedException {
        Dao dao = mock(UserDaoForTests.class);
        Input input = mock(Input.class);
        UserAction action = new FindByIdAction();
        when(input.askInt("Enter id: ")).thenReturn(1);
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(input, times(1)).askInt("Enter id: ");
        verify(dao, times(1)).findUserById(1);
    }
}
