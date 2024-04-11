package com.kruglov.coffeshop.model;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    int id;
    String login;
    String mail;
    String password;

    public User(int id, String login, String mail, String password) {
        this.id = id;
        this.login = login;
        this.mail = mail;
        this.password = password;
    }




}
