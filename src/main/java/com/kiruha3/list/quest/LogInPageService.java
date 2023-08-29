package com.kiruha3.list.quest;

import com.kiruha3.list.selfexceptions.WrongLoginException;
import com.kiruha3.list.selfexceptions.WrongPasswordException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LogInPageService implements LogInPageInterface {


    @Override
    public Boolean checkLog(String login) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,20}");
        Matcher matcher = pattern.matcher(login);
        if (!matcher.matches()){
            throw new WrongLoginException();
        }else
            return true;
    }

    @Override
    public Boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,20}");
       // Matcher matcher = pattern.matcher(password);
        if (!pattern.matcher(password).matches()){
            throw new WrongPasswordException();
        }else
            return true;
    }

    @Override
    public Boolean passToPassconfirm(String password, String confirmPassword) {
        if (!Objects.equals(password, confirmPassword)) {
            throw new WrongPasswordException();
        }
        return true;
    }

    @Override
    public void  getCheck(String checkLog, String checkPassword, String passToPassconfirm) {
        checkLog(checkLog);
        checkPassword(checkPassword);
        passToPassconfirm(checkPassword, passToPassconfirm);
    }
}
