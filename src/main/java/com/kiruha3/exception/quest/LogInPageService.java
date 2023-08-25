package com.kiruha3.exception.quest;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LogInPageService implements LogInPageInterface {


    @Override
    public Boolean checkLog(String login) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,20}");
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    @Override
    public Boolean checkPassword(String password) {
        return true;
    }

    @Override
    public Boolean passToPassconfirm(String password, String confirmPassword) {
        return true;
    }

    @Override
    public Boolean getCheck(String checkLog, String checkPassword, String passToPassconfirm) {
        return checkLog(checkLog) && checkPassword(checkPassword) && passToPassconfirm(checkPassword, passToPassconfirm);


    }
}
