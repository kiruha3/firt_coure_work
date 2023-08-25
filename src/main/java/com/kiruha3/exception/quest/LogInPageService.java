package com.kiruha3.exception.quest;

import org.springframework.stereotype.Service;

@Service
public class LogInPageService implements LogInPageInterface{


    @Override
    public Boolean checkLog(String login) {
        return null;
    }

    @Override
    public Boolean checkPassword(String password) {
        return null;
    }

    @Override
    public Boolean passToPassconfirm(String password, String confirmPassword) {
        return null;
    }

    @Override
    public Boolean getCheck(String checkLog, String checkPassword, String passToPassconfirm) {
        return null;
    }
}
