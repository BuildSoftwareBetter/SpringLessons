package com.david.SL;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Customer {

    public Customer(String country, String name, int id) {
        this.name = name;
        this.id = id;
        this.country = country;
    }

    public Customer(String country, int id, String name) {
        this.name = name;
        this.id = id;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return ("Id" + id + "Country " + this.country + ", Name " + this.name);
    }

    public Customer(){}

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("Init method after properties are set : ");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }
}