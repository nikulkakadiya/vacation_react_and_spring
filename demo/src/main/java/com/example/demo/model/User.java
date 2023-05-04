package com.example.demo.model;

public class User {

    int id;
    String fname;
    String lname;
    String city;

    public User() {

    }

    public User(int id, String fname, String lname, String city) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
