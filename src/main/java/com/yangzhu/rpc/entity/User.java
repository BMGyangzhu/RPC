package com.yangzhu.rpc.entity;

/**
 * @author bgmyangzhu
 * @date 2024/11/8 21:19
 */
public class User {
    private String username;
    private Integer id;

    public User(String username) {
        this.username = username;
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String username, Integer id) {
        this.username = username;
        this.id = id;
    }

    public User() {
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
