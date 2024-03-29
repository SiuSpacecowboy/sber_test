package com.example;

import com.example.not_web_app.dao.Dao;
import com.example.not_web_app.dao.UserDao;
import com.example.not_web_app.dao.UserDaoForTests;
import com.example.not_web_app.input.Input;
import com.example.not_web_app.models.User;
import com.example.not_web_app.user_actions.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UserActionServiceTest {

    @Test
    public void CreateActionSuccessTest() throws InterruptedException {
        Dao dao = mock(UserDao.class);
        Input input = mock(Input.class);
        UserActionService action = new CreateActionServiceImpl();
        when(input.askInt("Enter age: ")).thenReturn(20);
        when(input.askStr("Enter nickname: ")).thenReturn("Max");
        when(input.askTwoSymb("F", "M",
                "Select your gender, F if female, M if male: ")).thenReturn("M");
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(dao, times(1)).save(any(User.class));
    }

    @Test
    public void CreateActionAgeBellow18Test() throws InterruptedException {
        Dao dao = mock(UserDao.class);
        Input input = mock(Input.class);
        UserActionService action = new CreateActionServiceImpl();
        when(input.askInt("Enter age: ")).thenReturn(16);
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(dao, never()).save(any(User.class));
    }

    @Test
    public void DeleteActionTest() throws InterruptedException {
        Dao dao = mock(UserDaoForTests.class);
        Input input = mock(Input.class);
        UserActionService action = new DeleteActionServiceImpl();
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
        UserActionService action = new EditActionServiceImpl();
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
        UserActionService action = new FindByIdActionServiceImpl();
        when(input.askInt("Enter id: ")).thenReturn(1);
        boolean result = action.execute(input, dao);
        assertTrue(result);
        verify(input, times(1)).askInt("Enter id: ");
        verify(dao, times(1)).findUserById(1);
    }
}
