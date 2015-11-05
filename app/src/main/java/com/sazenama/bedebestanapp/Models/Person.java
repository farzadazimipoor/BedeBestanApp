package com.sazenama.bedebestanapp.Models;


public class Person {

    private String name;
    private String lastname;
    private int gender;

    public Person() {
    }

   /* public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }*/

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String toString(){
        return "[ "+name+" ][ "+lastname+" ]";
    }
}
