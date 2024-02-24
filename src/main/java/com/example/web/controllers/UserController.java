package com.example.web.controllers;

import com.example.web.dto.User;
import com.example.web.services.CrudService;
import com.example.web.services.UserCrudServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Контроллер, отвечающий за обработку запросов, связанных с пользователями.
 * Не использовал RestController, а обычный, чтобы нагляднее показать работу приложения.
 * Все представления лежат в папке templates.
 * Чтобы посмотреть результат работы, запустите программу и перейдите по адресу:
 * http://localhost:8080/api/v1/meetings/users
 */
@Controller
@RequestMapping(value = "api/v1/meetings")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class.getName());
    private final CrudService service;

    /**
     * Конструктор класса UserController.
     *
     * @param service Реализация интерфейса CrudService для работы с пользователями
     */
    @Autowired
    public UserController(UserCrudServiceImpl service) {
        this.service = service;
    }

    /**
     * Получить всех пользователей.
     *
     * @param model Модель для передачи данных в представление(html страницу)
     * @return Строка, указывающая на представление с пользователями
     */
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.findAllUsers());
        log.info("Успешный поиск всех пользователей.");
        return "users";
    }

    /**
     * Получить информацию о конкретном пользователе.
     *
     * @param id    Идентификатор пользователя
     * @param model Модель для передачи данных в представление
     * @return Строка, указывающая на представление с информацией о пользователе
     */
    @GetMapping("/users/{id}")
    public String getOneUser(@PathVariable("id") long id, Model model) {
       User resUser = service.findUserById(id);
        model.addAttribute("user", resUser);
        log.info("Успешное получение пользователя.");
        return "one-user";
    }

    /**
     * Отображает форму для создания нового пользователя.
     *
     * @param user Объект пользователя для передачи в форму
     * @return Строка, указывающая на представление для создания нового пользователя
     */
    @GetMapping("/users/save")
    public String formNewUser(@ModelAttribute("user") User user) {
        return "user-new";
    }

    /**
     * Обрабатывает запрос на создание нового пользователя.
     *
     * @param user           Объект пользователя, переданный из формы
     * @param bindingResult  Результаты валидации данных пользователя
     * @return Строка, указывающая на перенаправление после успешного создания пользователя
     */
    @PostMapping("/users")
    public String postNewUser(@ModelAttribute("user") @Valid User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-new";
        }
        service.saveUser(user);
        log.info("Успешное добавление пользователя " + user.getNickname() +  " в БД.");
        return "redirect:/api/v1/meetings/users";
    }

    /**
     * Отображает форму для редактирования пользователя по идентификатору.
     *
     * @param id     Идентификатор пользователя для редактирования
     * @param model  Модель для передачи данных в представление
     * @return Строка, указывающая на представление для редактирования пользователя
     */
    @GetMapping("/users/{id}/edit")
    public String formEditUser(@PathVariable("id") long id, Model model) {
        User resUser = service.findUserById(id);
        model.addAttribute("user", resUser);
        return "user-edit";
    }

    /**
     * Обновляет данные пользователя по идентификатору.
     *
     * @param id             Идентификатор пользователя для обновления
     * @param user           Объект пользователя с обновленными данными
     * @param bindingResult  Результаты валидации данных пользователя
     * @return Строка, указывающая на перенаправление после успешного обновления пользователя
     */
    @PatchMapping("/users/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-edit";
        }
        service.editUser(user.getNickname(), user.getName(), id);
        log.info("Успешное изменение пользователя " + user.getNickname() + ".");
        return "redirect:/api/v1/meetings/users/{id}";
    }

    /**
     * Удаляет пользователя по идентификатору.
     *
     * @param id Идентификатор пользователя для удаления
     * @return Строка, указывающая на перенаправление после успешного удаления пользователя
     */
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        service.deleteUser(id);
        log.info("Удаление пользователя из БД.");
        return "redirect:/api/v1/meetings/users";
    }
}

