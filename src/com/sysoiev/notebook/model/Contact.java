package com.sysoiev.notebook.model;


public class Contact {

    private String surname;
    private String name;
    private int phoneNumber;
    private String city;

    public Contact(String surname, String name, int phoneNumber, String city) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
