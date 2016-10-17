package com.company;

/**
 * Created by michaelplott on 10/17/16.
 */
public class User {
    int id;
    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
