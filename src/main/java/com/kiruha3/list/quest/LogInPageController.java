package com.kiruha3.list.quest;

import com.kiruha3.list.selfexceptions.WrongLoginException;
import com.kiruha3.list.selfexceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInPageController {
    private final LogInPageService logInPageService;

    public LogInPageController(LogInPageService logInPageService) {
        this.logInPageService = logInPageService;
    }

//    @GetMapping()
//    public String logInPage() {
//        return "Задайте логин пароль и повторите пароль";
//    }

        @GetMapping(path = "/login")
    public String logIn(@RequestParam(required = false) String login,
                        @RequestParam String password,
                        @RequestParam String confirmPassword) {
            try {
                logInPageService.getCheck(login,password,confirmPassword);//используйте: http://localhost:8080/login?login=java_skypro_go&password=D_1hWiKjjP_9&confirmPassword=D_1hWiKjjP_9
                return "Вы вошли в систему: "+login;
            } catch (WrongLoginException e) {
                return "С Логином что-то не так";
            } catch (WrongPasswordException e) {
                return "С паролем что-то не так";
            }

    }
}
