package com.example.web_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/** Класс запуска приложения
 * После запуска приложения, перейдите по ссылке для просмотра работы функционала программы:
 * <a href="http://localhost:8080/api/v1/meetings/users">MeetingApp.</a>
 * */
@SpringBootApplication
@Configuration
public class CrudSpringSberApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringSberApplication.class, args);
	}

}
