package com.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


    private Date birthday;

    private Integer id;

    private Integer port;

    private String name;


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "birthday='" + birthday + '\'' +
                ", id=" + id +
                ", port=" + port +
                ", name='" + name + '\'' +
                '}';
    }
}
