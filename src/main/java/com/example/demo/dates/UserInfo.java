package com.example.demo.dates;

import java.util.Date;

/**
 * <h1>用户信息</h1>
 * */
public class UserInfo {

    private Long id;
    private String name;

    private Date birthday;

    public UserInfo() {

    }

    public UserInfo(Long id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
