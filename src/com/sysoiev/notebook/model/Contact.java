package com.sysoiev.notebook.model;

public class Contact {

    private String surname;
    private String name;
    private String phoneNumber;
    private int age;

    public Contact(String surname, String name, String phoneNumber, int age) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact:" + '\n' +
                "surname = " + surname + '\n' +
                "name = " + name + '\n' +
                "phone number = " + phoneNumber + '\n' +
                "age = " + age;
    }

}