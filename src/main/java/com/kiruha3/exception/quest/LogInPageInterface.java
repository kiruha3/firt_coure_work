package com.kiruha3.exception.quest;

public interface LogInPageInterface {
    Boolean checkLog(String login);
    Boolean checkPassword(String password);
    Boolean passToPassconfirm(String password,String confirmPassword);
    void getCheck(String checkLog, String checkPassword, String passToPassconfirm);
}
