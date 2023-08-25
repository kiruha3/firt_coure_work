package com.kiruha3.exception.quest;

import com.kiruha3.exception.selfexceptions.WrongLoginException;
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
//        if (matcher.matches()==false){
//            throw new WrongLoginException();
//        }
        return matcher.matches();
    }

    @Override
    public Boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]{1,20}");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    @Override
    public Boolean passToPassconfirm(String password, String confirmPassword) {
        return Objects.equals(password, confirmPassword);
    }

    @Override
    public String getCheck(String checkLog, String checkPassword, String passToPassconfirm) {
        return checkLog(checkLog).toString() + checkPassword(checkPassword).toString() + passToPassconfirm(checkPassword, passToPassconfirm).toString();


    }
}
