package com.david.SL;

public class User {

    public User(){

    }

    public User(Role role){
        this.role=role;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString() {
        return "Name = " + this.name + ",Role " + this.role.getName();
    }
}