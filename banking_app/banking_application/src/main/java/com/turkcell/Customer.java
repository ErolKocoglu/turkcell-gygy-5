package com.turkcell;

import java.util.ArrayList;

public class Customer {
    //private Account account; I removed for now
    private String name;
    private int id;
    private String password;

    public Customer(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

}
