package com.kiruha3.exception.quest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInPageController {
    private final LogInPageService logInPageService;

    public LogInPageController(LogInPageService logInPageService) {
        this.logInPageService = logInPageService;
    }

    @GetMapping()
    public String logInPage() {
        return "Задайте логин пароль и повторите пароль";
    }

    @GetMapping(path = "/LogIn")
    public Boolean logIn(@RequestParam(required = false) String login,
                        @RequestParam String password,
                        @RequestParam String confirmPassword) {
        return logInPageService.getCheck(login,password,confirmPassword);
    }
}
