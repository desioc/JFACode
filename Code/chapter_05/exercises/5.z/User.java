package com.claudiodesio.authentication;

public class User {
    public String name;
    public String username;
    public String password;
    
    public User(String n, String u, String p) {
        this.name = n;
        this.username = u;
        this.password = p;
    }
}