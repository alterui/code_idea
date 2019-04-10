package com.lr.bridge.pojo;

public class User {
    private Integer id;

    private String userName;

    private String fullName;

    private String password;

    private Integer permission;

    public User(Integer id, String userName, String fullName, String password, Integer permission) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.permission = permission;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}