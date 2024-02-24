package com.example.web.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * Класс-обработчик глобальных исключений для обработки исключений в приложении.
 */
@ControllerAdvice
public class GlobalExceptionsHandler {

    private static final Logger log = Logger.getLogger(GlobalExceptionsHandler.class.getName());

    /**
     * Обработчик исключения NoResourceFoundException.
     *
     * @param e Исключение типа NoResourceFoundException
     * @return Строка, указывающая на html страницу для неверного URL адреса
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public String notFoundException(NoResourceFoundException e) {
        log.info("Введен неверный url адрес.");
        return "wrong-url";
    }

    /**
     * Обработчик исключения NoSuchElementException.
     *
     * @param e Исключение типа NoSuchElementException
     * @return Строка, указывающая на html страницу для несуществующего пользователя
     */
    @ExceptionHandler(NoSuchElementException.class)
    public String nonExistentUser(NoSuchElementException e) {
        log.info("Переход на страницу несуществующего пользователя.");
        return "wrong-user";
    }
}
