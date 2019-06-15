package com.qhit.pojo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @Date:2019/6/1
 * @Description:
 * @version:1.0
 */
public class Users {
    private int id;
    @NotBlank   //非空验证
    private String name;
    @NotBlank
    private String pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Users(int id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
