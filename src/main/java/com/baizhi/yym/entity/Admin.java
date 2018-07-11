package com.baizhi.yym.entity;

import java.io.Serializable;

/**
 * Created by yamin on 2018/7/5.
 */
public class Admin implements Serializable{
    private String id;
    private String name;
    private String password;
    private String level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Admin(String id, String name, String password, String level) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
